package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class InformationController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public String getInputNames() {
        outputView.printInputCoachNamesPrompt();

        try {
            String names = inputView.inputNames();
            return names;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getInputNames();
        }
    }

    public void getInputCannotEatCoach(String names) {
        String[] name = names.split(",");

        for(int i=0; i<name.length; i++){
            inputCannotEatCoach(name[i]);
        }
    }

    public String inputCannotEatCoach(String coach) {
        try {
            outputView.printInputCannotEatPrompt(coach);
            String foods = inputView.inputFood();
            return foods;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputCannotEatCoach(coach);
        }
    }
}
