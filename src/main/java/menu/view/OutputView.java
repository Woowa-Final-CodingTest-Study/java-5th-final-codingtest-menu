package menu.view;

import menu.constant.OutputMessage;
import menu.model.Coach;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private void println() {
        System.out.println();
    }

    private void println(String message) {
        System.out.println(message);
    }


    public void printStartMenuRecommendation() {
        println(OutputMessage.PRINT_START_MENU_RECOMMENDATION);
        println();
    }

    public void notifyInputCoachNames() {
        println(OutputMessage.NOTIFY_INPUT_COACH_NAMES);
    }
}
