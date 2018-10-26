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
    private static final String PAGE_MAPPING = "book/{bookName}/{pageNumber}";

    @GetMapping(HOME_MAPPING)
    public String index() {
        return "index";
    }

    @GetMapping(path = PAGE_MAPPING, produces = "text/html")
    public String page(
        @PathVariable("bookName") String bookName,
        @PathVariable("pageNumber") String pageNumber,
        HttpServletResponse response
    ) throws IOException {
        String path = "books/" + bookName + "/" + pageNumber;
        String fileName = "/public/html/" + path + ".html";
        if(PageController.class.getResource(fileName) == null){
            response.sendRedirect(HOME_MAPPING);
            return null;
        }
        return path;
    }
}
