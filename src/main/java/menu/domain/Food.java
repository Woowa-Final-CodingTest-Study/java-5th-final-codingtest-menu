package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Food {
    JAPANESE_FOOD(1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD(2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD(3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "달걀볶음", "고추잡채")),
    ASIAN_FOOD(4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD(5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int index;
    private final List<String> foods;

    Food(int index, List<String> foods) {
        this.index = index;
        this.foods = foods;
    }

    public static boolean isFoodExist(String foodName) {
        return Arrays.stream(Food.values())
                .anyMatch(foodCategory -> foodCategory.foods.contains(foodName));
    }

    public static String pickRandomFood(int categoryIndex) {
        for (Food food : values()) {
            if (categoryIndex == food.index) {
                return Randoms.shuffle(food.foods).get(0);
            }
        }
        return null;
    }
}
