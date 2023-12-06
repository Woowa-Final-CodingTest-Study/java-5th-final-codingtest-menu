package menu.controller;

import java.util.List;
import menu.domain.CoachGroup;
import menu.domain.DayOfWeek;
import menu.domain.Selection;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.ValidateError;

public class MenuSelectManager {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        startManager();

        CoachGroup coachGroup = new CoachGroup();
        List<String> names = registerCoach();
        for (String name : names) {
            coachGroup.addCoach(name, enrollHateFood(name));
        }

        showResult(coachGroup);

        endManager();
    }

    private void startManager() {
        outputView.printStartManager();
    }

    private List<String> registerCoach() {
        outputView.requestCoachName();
        return inputView.readCoachName();
    }

    private void endManager() {
        outputView.printEndManager();
    }

    private List<String> enrollHateFood(String name) {
        outputView.requestHateFood(name);
        return registerHateFood();
    }

    private List<String> registerHateFood() {
        try {
            List<String> hateFoods = inputView.readHateFood();
            ValidateError.validateFoodExist(hateFoods);
            return hateFoods;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return registerHateFood();
        }
    }

    void showResult(CoachGroup coachGroup) {
        Selection selection = new Selection();

        String dayOfWeekArrange = DayOfWeek.getDayOfWeekArrange();
        String selectionCategory = selection.getSelectionCategory();
        String selectionFoods = selection.getSelectionResult(coachGroup);

        outputView.printSelectionResult(dayOfWeekArrange, selectionCategory, selectionFoods);

    }
}
