package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    public List<String> readCoachName() {
        try {
            List<String> names = Arrays.asList(Console.readLine().split(","));
            validateNumberOfCoach(names.size());
            validateCoachName(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachName();
        }
    }

    void validateNumberOfCoach(int numberOfCoach) {
        validateMinCoachNumber(numberOfCoach);
        validateMaxCoachNumber(numberOfCoach);
    }

    void validateMinCoachNumber(int numberOfCoach) {
        if (numberOfCoach < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
    }

    void validateMaxCoachNumber(int numberOfCoach) {
        if (numberOfCoach > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 이하로 입력해야 합니다.");
        }
    }

    void validateCoachName(List<String> names) {
        validateDuplicateName(names);

        for (String name : names) {
            validateNameFormat(name);
            validateMinNameLength(name);
            validateMaxNameLength(name);
        }
    }

    void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    void validateNameFormat(String name) {
        if (!Pattern.matches("^[가-힣a-zA-Z]+$", name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 한글 또는 영어만 써야합나다.");
        }
    }

    void validateMinNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 이름은 2글자 이상이어야합니다");
        }
    }

    void validateMaxNameLength(String name) {
        if (name.length() < 4) {
            throw new IllegalArgumentException("[ERROR] 이름은 4글자 이하이어야합니다");
        }
    }
}
