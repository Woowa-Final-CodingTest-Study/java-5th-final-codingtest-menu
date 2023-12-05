package menu.controller;

import menu.model.Coach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        startMenuRecommendation();
        List<Coach> coaches = getCoaches();
    }

    private void startMenuRecommendation() {
        outputView.printStartMenuRecommendation();
    }

    private List<Coach> getCoaches() {
        outputView.notifyInputCoachNames();
        List<String> coachNames = inputView.readCoachNames();
        return coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
