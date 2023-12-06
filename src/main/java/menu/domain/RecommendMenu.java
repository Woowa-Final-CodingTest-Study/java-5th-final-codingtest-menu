package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendMenu {
    private String coach;
    private List<String> recommendMenu;

    public RecommendMenu(String coach, List<String> recommendMenu) {
        this.coach = coach;
        this.recommendMenu = recommendMenu;
    }

    public String getCoach() {
        return coach;
    }

    public List<String> getRecommendMenu() {
        return recommendMenu;
    }

    public static RecommendMenu initRecommend(String coachName) {
        return new RecommendMenu(coachName, new ArrayList<>(Collections.emptyList()));
    }

    public boolean checkDuplicateMenu(String menu) {
        if(recommendMenu.contains(menu)) {
            return true;
        }
        return false;
    }

    public void addRecommendMenu(String menu) {
        recommendMenu.add(menu);
    }
}
