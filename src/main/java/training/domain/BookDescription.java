package training.domain;

import lombok.Data;
import training.data.base.Identifiable;

@Data
public class BookDescription implements Identifiable, MenuElement {
    private String id;
    private String title;
    private String description;

    @Override
    public String getUrl() {
        return "/book/" + id + "/1";
    }

    @Override
    public String getLabel() {
        return title;
    }
}
