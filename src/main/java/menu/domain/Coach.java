package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> hateFood;

    Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }

}
