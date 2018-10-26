package training.data.base.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import lombok.extern.slf4j.Slf4j;
import training.data.base.AbstractDataService;
import training.data.base.Identifiable;

@SuppressWarnings({"unchecked", "WeakerAccess"})
@Slf4j
public class JarLoader<T extends Identifiable> extends AbstractLoader<T> {
    private final Class<T> clazz;
    private final String jarPath;
    private final AbstractDataService<T> dataService;

    public JarLoader(Class<T> clazz, AbstractDataService<T> dataService) {
        this.clazz = clazz;
        this.dataService = dataService;
        this.jarPath = dataService.getJarPath();
    }


    @Override
    public void load() {
        log.info("Loading from JAR... JarPath: {}", jarPath);

        JarFile jarFile = getJarEntries();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            loadJarEntry(jarFile, entries.nextElement());
        }
    }

    private JarFile getJarEntries() {
        try {
            CodeSource src = AbstractDataService.class.getProtectionDomain().getCodeSource();
            if (src != null) {
                URL jar = src.getLocation();
                JarURLConnection urlcon = (JarURLConnection) (jar.openConnection());
                return urlcon.getJarFile();
            } else {
                throw new IllegalStateException("CodeSource cannot be resolved");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadJarEntry(JarFile jarFile, JarEntry entry) {
        String entryName = entry.getName();
        try {
            if (entryName.endsWith(jarPath)) {
                log.info("Matched element: {}", entryName);
                String contentString = readJarEntry(jarFile, entry);
                T content = objectMapper.readValue(contentString, clazz);
                putElement(content, dataService, jarPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readJarEntry(JarFile jarFile, JarEntry entry) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(entry)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }

        return new String(builder.toString().getBytes(), Charset.forName("UTF-8"));
    }
}
