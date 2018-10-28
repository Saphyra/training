package training.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import training.domain.MenuElement;
import training.service.MenuFacade;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DataController {
    private static final String GET_MENU_MAPPING = "menu/{menuId}";

    private final MenuFacade menuFacade;

    @GetMapping(GET_MENU_MAPPING)
    public List<? extends MenuElement> getBooks(
        @PathVariable("menuId") String menuId
    ){
        return new ArrayList<>(menuFacade.getMenu(menuId).values());
    }
}
