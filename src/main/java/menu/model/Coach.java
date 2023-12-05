package menu.model;

import java.util.List;

public class Coach {
    private final String name;
    private List<String> menuDislike;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void updateMenuDislike(List<String> menuDislike) {
        this.menuDislike = menuDislike;
    }
}
