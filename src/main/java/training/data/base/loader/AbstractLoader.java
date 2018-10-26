package training.data.base.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import training.data.base.AbstractDataService;
import training.data.base.ContentLoader;
import training.data.base.Identifiable;

@SuppressWarnings("WeakerAccess")
@Slf4j
public abstract class AbstractLoader<T extends Identifiable> implements ContentLoader {
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected void putElement(T content, AbstractDataService<T> dataService) {
        log.info("Loaded element. Key: {}, Value: {}", content.getId(), content);
        dataService.put(content.getId(), content);
    }
}
