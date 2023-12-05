package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import menu.constant.ErrorMessage;
import menu.constant.MenuList;

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
        while (true) {
            try {
                String input = Console.readLine();
                List<String> coachNames = List.of(input.split(","));
                validateCoachCount(coachNames);
                validateCoachNameLength(coachNames);
                validateCoachNameUnique(coachNames);
                return coachNames;
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    private void validateCoachCount(List<String> coachNames) {
        int count = coachNames.size();
        if (count < 2 || count > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_OUT_OF_RANGE);
        }
    }

    private void validateCoachNameLength(List<String> names) {
        for (String name : names) {
            int length = name.length();
            if (length < 2 || length > 4) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_OUT_OF_RANGE);
            }
        }
    }

    private void validateCoachNameUnique(List<String> coachNames) {
        if (coachNames.size() != new HashSet<>(coachNames).size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_DUPLICATED);
        }
    }

    public List<String> readMenuDislike() {
        while (true) {
            try {
                String input = Console.readLine();
                List<String> menus = List.of(input.split(","));
                validateMenuCount(menus);
                validateMenuExist(menus);
                validateMenuUnique(menus);
                return menus;
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    private void validateMenuCount(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.MENU_COUNT_OUT_OF_RANGE);
        }
    }

    private void validateMenuExist(List<String> menus) {
        menus.forEach(menu -> {
            if (!MenuList.contains(menu)) {
                throw new IllegalArgumentException(ErrorMessage.MENU_NOT_EXIST);
            }
        });
    }

    private void validateMenuUnique(List<String> menus) {
        if(menus.size() != new HashSet<>(menus).size())
            throw new IllegalArgumentException(ErrorMessage.MENU_DUPLICATED);
    }

    private void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
