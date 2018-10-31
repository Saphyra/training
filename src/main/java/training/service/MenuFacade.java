package training.service;

import org.springframework.stereotype.Service;
import training.data.CssMenu;
import training.data.HtmlMenu;
import training.domain.MenuElement;
import training.data.IndexMenu;

import java.util.HashMap;
import java.util.Map;

@Service
public class MenuFacade{
    private final Map<String, Map<String, ? extends MenuElement>> menus = new HashMap<>();

    public MenuFacade(
        IndexMenu indexMenu,
        HtmlMenu htmlMenu,
        CssMenu cssMenu
    ) {
        menus.put("index", indexMenu);
        menus.put("html", htmlMenu);
        menus.put("css", cssMenu);
    }

    public Map<String, ? extends MenuElement> getMenu(String key){
        return menus.get(key);
    }
}
