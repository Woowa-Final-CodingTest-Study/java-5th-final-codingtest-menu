package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCoachName() {
        try {
            List<String> names = Arrays.asList(Console.readLine().split(","));
            ValidateError.validateNumberOfCoach(names.size());
            ValidateError.validateCoachName(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }

    public List<String> readHateFood() {
        try {
            List<String> hateFood = Arrays.asList(Console.readLine().split(","));
            ValidateError.validateNumberOfFood(hateFood.size());
            ValidateError.validateFood(hateFood);
            return hateFood;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readHateFood();
        }
    }
}
