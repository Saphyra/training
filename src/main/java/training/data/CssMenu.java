package training.data;

import training.data.base.AbstractDataService;
import training.domain.Chapter;

public class CssMenu extends AbstractDataService<Chapter> {
    public CssMenu(String source) {
        super(source);
    }

    @Override
    public void init() {
        load(Chapter.class);
    }
}
