package training.data.base.loader;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.FilenameUtils;

public class JsonFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        return FilenameUtils.isExtension(file.getName(), "json");
    }
}
