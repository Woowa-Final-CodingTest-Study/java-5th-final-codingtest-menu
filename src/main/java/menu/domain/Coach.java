package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFood;

    public Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = Collections.unmodifiableList(hateFood);
    }

    public boolean isHateFood(String food) {
        if (hateFood.contains(food)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

}
