package training.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import training.domain.MapElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class SampleController {
    private static final String HTML_FORM_SAMPLE_MAPPING = "/sample/html/form";

    @PostMapping(HTML_FORM_SAMPLE_MAPPING)
    public ModelAndView htmlFormSample(
        @RequestBody String body
    ) {
        log.info(body);

        ModelAndView result = new ModelAndView("books/html/sample_form_data");
        List<MapElement<String>> variables = parseBody(body);
        result.addObject("variables", variables);

        return result;
    }

    private List<MapElement<String>> parseBody(String body) {
        String[] fields = body.split("&");
        return Arrays.stream(fields)
            .map(field -> field.split("="))
            .map(arr -> {
                MapElement<String> element = new MapElement<>();
                element.setKey(arr[0]);
                element.setValue(arr.length > 1 ? arr[1] : "");
                return element;
            })
            .collect(Collectors.toList());
    }
}
