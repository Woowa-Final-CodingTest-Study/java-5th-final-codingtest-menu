package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public enum FoodCategory {
    JAPANESE(1, "일식", Food.JAPANESE_FOOD),
    KOREAN(2, "한식", Food.KOREAN_FOOD),
    CHINESE(3, "중식", Food.CHINESE_FOOD),
    ASIAN(4, "아시안", Food.ASIAN_FOOD),
    WESTERN(5, "양식", Food.WESTERN_FOOD);

    private final int index;
    private final String name;
    private final Food food;

    FoodCategory(int index, String name, Food food) {
        this.index = index;
        this.name = name;
        this.food = food;
    }

    public static int pickRandomCategoryIndex() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public String getName() {
        return name;
    }
}
