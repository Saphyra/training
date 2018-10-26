package training.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PageController {
    private static final String HOME_MAPPING = "/";
    private static final String PAGE_MAPPING = "{bookName}/{pageNumber}";
    private static final String ERROR_MAPPING = "/error";

    @GetMapping({HOME_MAPPING, ERROR_MAPPING})
    public String index() {
        return "index";
    }

    @GetMapping(PAGE_MAPPING)
    public String page(
        @PathVariable("bookName") String bookName,
        @PathVariable("pageNumber") String pageNumber,
        HttpServletResponse response
    ) throws IOException {
        String path = "books/" + bookName + "/" + pageNumber;
        String fileName = "/public/html/" + path + ".html";
        if(PageController.class.getResource(fileName) == null){
            return index();
        }
        return path;
    }
}
