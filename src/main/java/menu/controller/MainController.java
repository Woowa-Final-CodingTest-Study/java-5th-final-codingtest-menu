package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.constant.DayOfWeekConstant;
import menu.constant.MenuCategory;
import menu.domain.RecommendMenu;
import menu.domain.RecommendMenus;
import menu.domain.UnPreferredMenu;
import menu.domain.UnPreferredMenus;
import menu.view.OutputView;

public class MainController {

    private final InformationController informationController;
    private final RecommendController recommendController;

    public MainController() {
        informationController = new InformationController();
        recommendController = new RecommendController();
    }

    OutputView outputView = new OutputView();

    public void run() {
        outputView.printStartRecommend();
        String names = getCoachNames();
        RecommendMenus recommendMenus = initRecommendMenu(names);
        UnPreferredMenus unPreferredMenus = getCannotEatFoods(names);

        printWeekRecommendMenus(recommendMenus, unPreferredMenus);
    }

    public String getCoachNames() {
         String names = informationController.getInputNames();
         return names;
    }

    public RecommendMenus initRecommendMenu(String names) {
        String[] name = names.split(",");
        List<RecommendMenu> recommendMenus = new ArrayList<>();

        for(String coachName : name) {
            RecommendMenu coachMenu = RecommendMenu.initRecommend(coachName);

            recommendMenus.add(coachMenu);
        }

        return new RecommendMenus(recommendMenus);
    }
    public UnPreferredMenus getCannotEatFoods(String names) {
        List<UnPreferredMenu> unPreferredMenus = informationController.getInputCannotEatCoach(names);

        return new UnPreferredMenus(unPreferredMenus);
    }

    public void printWeekRecommendMenus(RecommendMenus recommendMenus, UnPreferredMenus unPreferredMenus) {
        RecommendMenus weekCommendMenus = recommendController.requestWeekCommend(recommendMenus, unPreferredMenus);

        outputView.printCommendResult(generateRecommendResult(weekCommendMenus));
    }

    public StringBuilder generateRecommendResult(RecommendMenus recommendMenus) {
        StringBuilder result = new StringBuilder();

        result.append(generateDayOfWeekString())
                .append(generateCategoryString())
                .append(generateRecommendMenuString(recommendMenus));

        return result;
    }

    public StringBuilder generateDayOfWeekString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ 구분");
        for(String day : DayOfWeekConstant.dayOfWeek) {
            sb.append(" | ").append(day);
        }
        sb.append(" ]").append("\n");

        return sb;
    }

    public StringBuilder generateCategoryString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ 카테고리");
        for(MenuCategory menuCategory : MenuCategory.values()) {
            sb.append(" | ").append(menuCategory.getCategory());
        }
        sb.append(" ]").append("\n");

        return sb;
    }

    public StringBuilder generateRecommendMenuString(RecommendMenus recommendMenus) {
        StringBuilder sb = new StringBuilder();

        for(RecommendMenu recommendMenu : recommendMenus.getRecommendMenus()) {
            sb.append("[ ").append(recommendMenu.getCoach());

            for(String menu : recommendMenu.getRecommendMenu()) {
                sb.append(" | ").append(menu);
            }
            sb.append(" ]").append("\n");
        }

        return sb;
    }

}
