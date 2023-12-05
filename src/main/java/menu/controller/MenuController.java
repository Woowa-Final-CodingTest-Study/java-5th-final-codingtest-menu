package menu.controller;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.Category;
import menu.constant.MenuList;
import menu.model.Coach;
import menu.model.DayOfWeekWrapper;
import menu.model.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private static MenuController menuController;
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static MenuController getInstance(InputView inputView, OutputView outputView) {
        if (menuController == null) {
            menuController = new MenuController(inputView, outputView);
        }
        return menuController;
    }

    public void init() {
        MenuList.init();
        startMenuRecommendation();
        List<Coach> coaches = getCoachNames();
        updateMenuDislike(coaches);

        recommendMenu(coaches);
    }

    private void startMenuRecommendation() {
        outputView.printStartMenuRecommendation();
    }

    private List<Coach> getCoachNames() {
        outputView.notifyInputCoachNames();
        List<String> coachNames = inputView.readCoachNames();
        return coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private void updateMenuDislike(List<Coach> coaches) {
        coaches.forEach(coach -> {
            outputView.notifyInputMenuDislike(coach.getName());
            List<String> menuDislike = inputView.readMenuDislike();
            coach.updateMenuDislike(menuDislike);
        });
    }

    private void recommendMenu(List<Coach> coaches) {
        List<DayOfWeek> weekDays = DayOfWeekWrapper.weekDays();
        List<Category> categories = new ArrayList<>();
        List<Recommendation> recommendations = coaches.stream()
                .map(Recommendation::new)
                .collect(Collectors.toList());

        weekDays.forEach(dayOfWeek -> {
            Category category = Category.pickRandom();
            categories.add(category);
            List<String> menus = MenuList.get(category);
            recommendations.forEach(recommendation -> recommendation.addRandomMenu(menus));
        });

        outputView.printResult(categories, recommendations);
    }
}

















