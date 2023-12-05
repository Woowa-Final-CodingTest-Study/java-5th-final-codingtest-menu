package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constant.ErrorMessage;

import java.util.List;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public List<String> readCoachNames() {
        String input = Console.readLine();
        List<String> coachNames = List.of(input.split(","));
        validateCoachCount(coachNames);
        coachNames.forEach(this::validateCoachNameLength);
        return coachNames;
    }

    private void validateCoachCount(List<String> coachNames) {
        int count = coachNames.size();
        if (count < 2 || count > 5)
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_OUT_OF_RANGE);
    }

    private void validateCoachNameLength(String name) {
        int length = name.length();
        if (length < 2 || length > 4)
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_OUT_OF_RANGE);
    }
}
