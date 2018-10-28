package training.domain;

import lombok.Data;

@Data
public class Chapter extends AbstractMenuElement {
    private String id;
    private String label;
    private String number;
    private String description;
}
