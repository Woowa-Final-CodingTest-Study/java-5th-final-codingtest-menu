package menu.view;

import java.util.List;
import menu.constant.Category;
import menu.constant.OutputMessage;
import menu.model.Recommendation;

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

    private void printf(String message, Object... args) {
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

    public void printResult(List<Category> categories, List<Recommendation> recommendations) {
        println(OutputMessage.PRINT_RESULT_TITLE);
        println(OutputMessage.PRINT_RESULT_WEEKDAYS);
        printResultCategory(categories);
        recommendations.forEach(this::printResultRecommendation);
        println();
        println(OutputMessage.PRINT_RESULT_COMPLETE);
    }

    private void printResultCategory(List<Category> categories) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(OutputMessage.CATEGORY);
        categories.forEach(category -> sb.append(" | ").append(category));
        sb.append(" ]");
        println(sb.toString());
    }

    private void printResultRecommendation(Recommendation recommendation) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(recommendation.getCoachName());
        List<String> result = recommendation.getResult();
        result.forEach(menu -> sb.append(" | ").append(menu));
        sb.append(" ]");
        println(sb.toString());
    }
}
