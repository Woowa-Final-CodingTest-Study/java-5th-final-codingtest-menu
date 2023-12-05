package menu.constant;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    public static final int INDEX_MIN = 1;
    public static final int INDEX_MAX = 5;
    private final String category;

    Category(String category) {
        this.category = category;
    }

    public static Category of(int value) {
        if (value < INDEX_MIN || value > INDEX_MAX)
            throw new IllegalArgumentException(ExceptionMessage.CATEGORY_INDEX_OUT_OF_RANGE);
        return Category.values()[value-1];
    }

    public static Category pickRandom() {
        return Category.of(Randoms.pickNumberInRange(INDEX_MIN, INDEX_MAX));
    }


    @Override
    public String toString() {
        return category;
    }
}
