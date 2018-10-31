package training.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class PageController {
    private static final String HOME_MAPPING = "/";
    private static final String SOURCE_MAPPING = "/source";
    private static final String PAGE_MAPPING = "book/{bookName}/{pageNumber}";

    @GetMapping(HOME_MAPPING)
    public String index() {
        return "index";
    }

    @GetMapping(SOURCE_MAPPING)
    public String source(){
        return "source";
    }

    @GetMapping(path = PAGE_MAPPING, produces = "text/html")
    public String page(
        @PathVariable("bookName") String bookName,
        @PathVariable("pageNumber") String pageNumber,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {
        log.debug("Request uri: {}", request.getRequestURI());
        String path = "books/" + bookName + "/" + pageNumber;
        String fileName = "/public/html/" + path + ".html";
        log.info("File name: {}", fileName);
        if(PageController.class.getResource(fileName) == null){
            response.sendRedirect(HOME_MAPPING);
            return null;
        }
        return path;
    }
}
