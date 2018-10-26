package training.util;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ObjectMapperUtil {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    public static ObjectMapper getMapper(File file) {
        if(file.getName().endsWith(".yaml")){
            return YAML_MAPPER;
        }
        return JSON_MAPPER;
    }
}
