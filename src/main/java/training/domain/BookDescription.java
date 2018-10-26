package training.domain;

import lombok.Data;
import training.data.base.Identifiable;

@Data
public class BookDescription implements Identifiable, Openable {
    private String id;
    private String title;
    private String description;

    @Override
    public String getUrl() {
        return "/book/" + id + "/1";
    }
}
