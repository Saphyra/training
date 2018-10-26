package training.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import training.domain.BookDescription;
import training.service.data.BookDescriptionService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DataController {
    private static final String BOOK_LIST_MAPPING = "books";

    private final BookDescriptionService bookDescriptionService;

    @GetMapping(BOOK_LIST_MAPPING)
    public Map<String, BookDescription> getBooks(){
        Map<String, BookDescription> result = bookDescriptionService;
        log.debug("{}", result);
        return result;
    }
}
