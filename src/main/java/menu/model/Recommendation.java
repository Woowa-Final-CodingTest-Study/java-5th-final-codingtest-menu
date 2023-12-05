package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private final Coach coach;
    private final List<String> menus = new ArrayList<>();

    public Recommendation(Coach coach) {
        this.coach = coach;
    }

    public void addRandomMenu(List<String> menus) {
        String menuRecommended;
        do {
            menuRecommended = Randoms.shuffle(menus).get(0);
        } while (coach.dislike(menuRecommended));
        this.menus.add(menuRecommended);
    }

    public String getCoachName() {
        return coach.getName();
    }

    public List<String> getResult() {
        return menus;
    }
}
