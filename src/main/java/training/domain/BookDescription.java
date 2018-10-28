package training.domain;

import lombok.Data;
import training.data.base.Identifiable;

@Data
public class BookDescription extends AbstractMenuElement {
    private String id;
    private String title;
    private String description;

    @Override
    public String getNumber() {
        return "1";
    }

    @Override
    public String getLabel() {
        return title;
    }
}
