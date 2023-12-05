package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachGroup {
    List<Coach> coaches;

    public CoachGroup() {
        this.coaches = new ArrayList<>();
    }

    public void addCoach(String coachName, List<String> hateFood) {
        this.coaches.add(new Coach(coachName, hateFood));
    }

    public void makeCategorys() {
        List<Food> categorys = new ArrayList<>();
        while (categorys.size() < 5) {
            Food randomCategory = Food.pickRandomCategory();

            long sameCategoryCount = categorys.stream()
                    .filter(value -> value.equals(randomCategory))
                    .count();
            if (sameCategoryCount < 2) {
                categorys.add(randomCategory);
            }
        }
    }
}
