package training.service.data;

import training.data.base.AbstractDataService;
import training.domain.BookDescription;

public class BookDescriptionService extends AbstractDataService<BookDescription> {
    public BookDescriptionService(String source) {
        super(source);
    }

    @Override
    public void init() {
        load(BookDescription.class);
    }
}
