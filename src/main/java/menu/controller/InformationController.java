package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.UnPreferredMenu;
import menu.domain.UnPreferredMenus;
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

    public List<UnPreferredMenu> getInputCannotEatCoach(String names) {
        String[] name = names.split(",");
        List<UnPreferredMenu> unPreferredMenus = new ArrayList<>();
        for(int i=0; i<name.length; i++){
            String foods = inputCannotEatCoach(name[i]);

             unPreferredMenus.add(new UnPreferredMenu(name[i], Arrays.asList(foods.split(","))));
        }

        return unPreferredMenus;
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
