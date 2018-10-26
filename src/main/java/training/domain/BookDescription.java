package training.domain;

import lombok.Data;
import training.data.base.Identifiable;

@Data
public class BookDescription implements Identifiable {
    private String url;
    private String title;
    private String description;

    @Override
    public String getId() {
        return url;
    }
}
