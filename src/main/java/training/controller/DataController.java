package training.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import training.domain.BookDescription;
import training.domain.MenuElement;
import training.service.MenuFacade;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DataController {
    private static final String GET_MENU_MAPPING = "menu/{menuId}";

    private final MenuFacade menuFacade;

    @GetMapping(GET_MENU_MAPPING)
    public Map<String, ? extends MenuElement> getBooks(
        @PathVariable("menuId") String menuId
    ){
        return menuFacade.getMenu(menuId);
    }
}
