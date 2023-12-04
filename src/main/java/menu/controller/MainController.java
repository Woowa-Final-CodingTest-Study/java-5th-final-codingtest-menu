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
        getCoachName();
    }

    public void getCoachName() {
        informationController.getInputNames();
    }
}
