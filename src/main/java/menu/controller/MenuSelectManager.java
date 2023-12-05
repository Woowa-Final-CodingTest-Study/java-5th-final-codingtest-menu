package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuSelectManager {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        startManager();

        endManager();
    }

    private void startManager() {
        outputView.printStartManager();
    }

    private void endManager() {
        outputView.printEndManager();
    }
}
