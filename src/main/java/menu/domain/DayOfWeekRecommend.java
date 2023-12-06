package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.constant.DayOfWeekConstant;
import menu.constant.Menu;

public class DayOfWeekRecommend {

    RecommendCategory recommendCategory = new RecommendCategory();

    public RecommendMenus generateWeekRecommend(RecommendMenus recommendMenus, UnPreferredMenus unPreferredMenus) {
        for(String day : DayOfWeekConstant.dayOfWeek) {
            recommendMenus = generateDayRecommend(recommendMenus, unPreferredMenus);
        }

        return recommendMenus;
    }

    public RecommendMenus generateDayRecommend(RecommendMenus recommendMenus, UnPreferredMenus unPreferredMenus) {
        String category = recommendCategory.generateRecommendCategory();

        for(RecommendMenu recommendMenu : recommendMenus.getRecommendMenus()) {
            generateRecommendMenu(recommendMenu, unPreferredMenus, category);
        }

        return recommendMenus;
    }

    public void generateRecommendMenu(RecommendMenu recommendMenu, UnPreferredMenus unPreferredMenus, String category) {
        UnPreferredMenu unPreferredMenu = UnPreferredMenus.findCoachUnPreferredMenu(recommendMenu.getCoach(), unPreferredMenus);

        while(true) {
            String menu = Menu.getRecommendMenu(category);

            if(!checkUnPreferredMenus(menu, unPreferredMenu) && !recommendMenu.checkDuplicateMenu(menu)) {
                recommendMenu.getRecommendMenu().add(menu);
                break;
            }
        }
    }

    public boolean checkUnPreferredMenus(String recommendMenu, UnPreferredMenu unPreferredMenu) {
        if(unPreferredMenu.checkUnPreferredMenus(recommendMenu)) {
            return true;
        }
        return false;
    }
}
