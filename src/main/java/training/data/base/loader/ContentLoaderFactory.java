package training.data.base.loader;

import java.io.File;

import training.data.base.AbstractDataService;
import training.data.base.ContentLoader;
import training.data.base.Identifiable;

public class ContentLoaderFactory<T extends Identifiable> {
    public ContentLoader getInstance(Class<T> clazz, AbstractDataService<T> gameDataService) {
        File root = new File(gameDataService.getPath());
        if (root.exists()) {
            return new FileLoader<>(clazz, gameDataService);
        } else {
            return new JarLoader<>(clazz, gameDataService);
        }
    }
}

