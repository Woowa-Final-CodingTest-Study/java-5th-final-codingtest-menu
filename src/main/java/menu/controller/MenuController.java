package menu.controller;

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
}
