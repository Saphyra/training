package training.data.base.loader;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import training.data.base.AbstractDataService;
import training.data.base.Identifiable;

@SuppressWarnings({"WeakerAccess", "ConstantConditions", "unchecked"})
@Slf4j
public class FileLoader<T extends Identifiable> extends AbstractLoader<T> {
    private static final JsonFileFilter jsonFilter = new JsonFileFilter();

    private final Class<T> clazz;
    private final File root;
    private final AbstractDataService<T> dataService;

    public FileLoader(Class<T> clazz, AbstractDataService<T> dataService) {
        this.clazz = clazz;
        this.dataService = dataService;
        this.root = new File(dataService.getPath());
    }

    @Override
    public void load() {
        log.info("Loading elements from file.");
        if (root.isDirectory()) {
            File[] files = root.listFiles(jsonFilter);
            for (File file : files) {
                loadFile(file);
            }
        }else {
            //TODO load single file
        }
    }

    private void loadFile(File file) {
        try {
            parseFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(File file) throws IOException {
        T content = objectMapper.readValue(file, clazz);
        putElement(content, dataService, dataService.getPath());
    }
}
