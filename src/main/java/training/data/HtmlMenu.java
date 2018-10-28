package training.data;

import training.data.base.AbstractDataService;
import training.domain.Chapter;

public class HtmlMenu extends AbstractDataService<Chapter> {
    public HtmlMenu(String source) {
        super(source);
    }

    @Override
    public void init() {
        load(Chapter.class);
    }
}
