package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> hateFood;

    Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }

    boolean isHateFood(String food) {
        if (hateFood.contains(food)) {
            return true;
        }
        return false;
    }

    String getName() {
        return name;
    }

}
