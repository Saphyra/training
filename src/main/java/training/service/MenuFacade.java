package training.service;

import org.springframework.stereotype.Service;
import training.domain.MenuElement;
import training.service.data.IndexMenu;

import java.util.HashMap;
import java.util.Map;

@Service
public class MenuFacade{
    private final Map<String, Map<String, ? extends MenuElement>> menus = new HashMap<>();

    public MenuFacade(IndexMenu indexMenu) {
        menus.put("index", indexMenu);
    }

    public Map<String, ? extends MenuElement> getMenu(String key){
        return menus.get(key);
    }
}
