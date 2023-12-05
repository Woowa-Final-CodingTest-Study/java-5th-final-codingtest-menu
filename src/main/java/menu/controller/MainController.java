package menu.controller;

import menu.view.OutputView;

public class MainController {

    private final InformationController informationController;

    public MainController() {
        informationController = new InformationController();
    }

    OutputView outputView = new OutputView();

    public void run() {
        outputView.printStartRecommend();
        String names = getCoachNames();
        getCannotEatFoods(names);
    }

    public String getCoachNames() {
         String names = informationController.getInputNames();
         return names;
    }

    public void getCannotEatFoods(String names) {
        informationController.getInputCannotEatCoach(names);
    }
}
