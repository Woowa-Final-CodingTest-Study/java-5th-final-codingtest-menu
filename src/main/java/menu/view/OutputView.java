package menu.view;

import static menu.constants.SystemMessage.END_SELECTION;
import static menu.constants.SystemMessage.REQUEST_COACH_NAME;
import static menu.constants.SystemMessage.REQUEST_HATE_FOOD;
import static menu.constants.SystemMessage.SHOW_SELECTION_RESULT;
import static menu.constants.SystemMessage.START_SELECTION;

public class OutputView {
    public void printStartManager() {
        System.out.println(START_SELECTION + "\n");
    }

    public void printEndManager() {
        System.out.println(END_SELECTION);
    }

    public void requestCoachName() {
        System.out.println(REQUEST_COACH_NAME);
    }

    public void requestHateFood(String name) {
        System.out.printf("\n" + REQUEST_HATE_FOOD + "\n", name);
    }

    public void printSelectionResult(String days, String categorys, String selectionResult) {
        System.out.println("\n" + SHOW_SELECTION_RESULT);
        System.out.println(days + categorys + selectionResult);
    }
}
