package menu.view;

import static menu.constants.ErrorMessage.*;
import static menu.constants.SystemWords.MAX_HATE_FOOD_COUNT;
import static menu.constants.SystemWords.MAX_NAME_LENGTH;
import static menu.constants.SystemWords.MAX_NUMBER_COACH;
import static menu.constants.SystemWords.MIN_NAME_LENGTH;
import static menu.constants.SystemWords.MIN_NUMBER_COACH;

import java.util.List;
import java.util.regex.Pattern;
import menu.domain.Food;

public class ValidateError {
    public static void validateFoodExist(List<String> hateFoods) {
        for (String food : hateFoods) {
            if (!Food.isFoodExist(food)) {
                throw new IllegalArgumentException(NOT_EXIST_FOOD);
            }
        }
    }

    public static void validateNumberOfCoach(int numberOfCoach) {
        validateMinCoachNumber(numberOfCoach);
        validateMaxCoachNumber(numberOfCoach);
    }

    private static void validateMinCoachNumber(int numberOfCoach) {
        if (numberOfCoach < MIN_NUMBER_COACH) {
            throw new IllegalArgumentException(INCREASE_COACH_NUMBER);
        }
    }

    private static void validateMaxCoachNumber(int numberOfCoach) {
        if (numberOfCoach > MAX_NUMBER_COACH) {
            throw new IllegalArgumentException(REDUCE_COACH_NUMBER);
        }
    }

    public static void validateCoachName(List<String> names) {
        try {
            for (String name : names) {
                validateNameFormat(name);
                validateMinNameLength(name);
                validateMaxNameLength(name);
            }
            validateDuplicateName(names);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(HAVE_DUPLICATE_NAME);
        }
    }

    private static void validateNameFormat(String name) {
        if (!Pattern.matches("^[가-힣a-zA-Z]+$", name)) {
            throw new IllegalArgumentException(WRONG_NAME_FORMAT);
        }
    }

    private static void validateMinNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INCREASE_NAME_LENGTH);
        }
    }

    private static void validateMaxNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(REDUCE_NAME_LENGTH);
        }
    }

    public static void validateNumberOfFood(int numberOfFood) {
        if (numberOfFood > MAX_HATE_FOOD_COUNT) {
            throw new IllegalArgumentException(REDUCE_HATE_FOOD);
        }
    }

    public static void validateDuplicateFood(List<String> hateFood) {
        if (hateFood.size() != hateFood.stream().distinct().count()) {
            throw new IllegalArgumentException(HAVE_DUPLICATE_FOOD);
        }
    }

    public static void validateFoodNameLength(List<String> foods) {
        for (String food : foods) {
            if (food.isEmpty()) {
                throw new IllegalArgumentException(INCREASE_FOOD_NAME);
            }
        }
    }

    public static void validateFood(List<String> foods) {
        validateFoodNameLength(foods);
        validateDuplicateFood(foods);
    }
}
