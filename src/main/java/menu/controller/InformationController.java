package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class InformationController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public String getInputNames() {
        outputView.printInputCoachNamesPrompt();

        try {
            String input = inputView.inputNames();
            return input;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getInputNames();
        }

    }
}
