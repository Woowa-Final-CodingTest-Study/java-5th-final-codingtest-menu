package menu.controller;

import java.util.List;
import menu.domain.CoachGroup;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuSelectManager {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        startManager();

        CoachGroup coachGroup = new CoachGroup(registerCoach());

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
}
