package menu.domain;

import static menu.constants.SystemWords.MAX_CATEGORY_INDEX;
import static menu.constants.SystemWords.MIN_CATEGORY_INDEX;

import camp.nextstep.edu.missionutils.Randoms;

public enum FoodCategory {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    FoodCategory(String name) {
        this.name = name;
    }

    public static int pickRandomCategoryIndex() {
        return Randoms.pickNumberInRange(MIN_CATEGORY_INDEX, MAX_CATEGORY_INDEX);
    }

    public String getName() {
        return name;
    }
}
