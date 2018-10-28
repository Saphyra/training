package training.domain;

import lombok.Data;

@Data
public class Chapter extends AbstractMenuElement {
    private String bookId;
    private String label;
    private String number;
    private String description;

    public String getId(){
        return number;
    }

    @Override
    public String getUrl(){
        return "/book/" + bookId + "/" + number;
    }
}
