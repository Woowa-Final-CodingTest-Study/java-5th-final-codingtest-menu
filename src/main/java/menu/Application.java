package menu;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        MenuController menuController = MenuController.getInstance(inputView, outputView);
        menuController.init();
    }
}
