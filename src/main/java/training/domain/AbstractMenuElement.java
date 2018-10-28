package training.domain;

import training.data.base.Identifiable;

public abstract class AbstractMenuElement implements Identifiable, MenuElement {
    public String getUrl(){
        return "/book/" + getId() + "/" + getNumber();
    }
}
