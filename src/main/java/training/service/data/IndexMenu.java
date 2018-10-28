package training.service.data;

import training.data.base.AbstractDataService;
import training.domain.BookDescription;

public class IndexMenu extends AbstractDataService<BookDescription> {
    public IndexMenu(String source) {
        super(source);
    }

    @Override
    public void init() {
        load(BookDescription.class);
    }
}
