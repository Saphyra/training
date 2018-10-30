package training.domain;

import lombok.Data;

@Data
public class MapElement<T> {
    private String key;
    private T value;
}
