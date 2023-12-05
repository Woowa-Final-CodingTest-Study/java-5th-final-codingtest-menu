package menu.view;

import menu.constant.OutputMessage;

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

    private void printf(String message, String... args) {
        System.out.printf(message, args);
    }

    public void printStartMenuRecommendation() {
        println(OutputMessage.PRINT_START_MENU_RECOMMENDATION);
        println();
    }

    public void notifyInputCoachNames() {
        println(OutputMessage.NOTIFY_INPUT_COACH_NAMES);
    }

    public void notifyInputMenuDislike(String coachName) {
        printf(OutputMessage.NOTIFY_INPUT_MENU_DISLIKE, coachName);
    }
}
