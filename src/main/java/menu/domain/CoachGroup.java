package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachGroup {
    private final List<Coach> coaches;

    public CoachGroup() {
        this.coaches = new ArrayList<>();
    }

    public void addCoach(String coachName, List<String> hateFood) {
        this.coaches.add(new Coach(coachName, hateFood));
    }

    public boolean isFoodHatersExist(String food) {
        for (Coach coach : coaches) {
            if (coach.isHateFood(food)) {
                return true;
            }
        }
        return false;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
