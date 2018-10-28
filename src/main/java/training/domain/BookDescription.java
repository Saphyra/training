package training.domain;

import lombok.Data;

@Data
public class BookDescription extends AbstractMenuElement {
    private String id;
    private String title;
    private String description;

    @Override
    public String getNumber() {
        return "001";
    }

    @Override
    public String getLabel() {
        return title;
    }
}
