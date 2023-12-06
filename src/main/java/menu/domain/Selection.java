package menu.domain;

import static menu.constants.SystemWords.CATEGORY;
import static menu.constants.SystemWords.MAX_DUPLICATE_CATEGORY;
import static menu.constants.SystemWords.SELECTION_DAYS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Selection {
    List<Integer> categorys;

    public Selection() {
        categorys = selectCategorys();
    }


    public List<Integer> selectCategorys() {
        List<Integer> categorys = new ArrayList<>();
        while (categorys.size() < SELECTION_DAYS) {
            int randomCategoryIndex = FoodCategory.pickRandomCategoryIndex();
            long sameCategoryCount = categorys.stream()
                    .filter(value -> value.equals(randomCategoryIndex))
                    .count();

            if (sameCategoryCount < MAX_DUPLICATE_CATEGORY) {
                categorys.add(randomCategoryIndex);
            }
        }
        return categorys;
    }

    private List<String> selectFoods(CoachGroup coachGroup) {
        List<String> foods = new ArrayList<>();
        while (foods.size() < SELECTION_DAYS) {
            String randomFood = Food.pickRandomFood(categorys.get(foods.size()));
            if (!(foods.contains(randomFood) || coachGroup.isFoodHatersExist(randomFood))) {
                foods.add(randomFood);
            }
        }
        return foods;
    }

    public String getSelectionCategory() {
        List<String> days = categorys.stream()
                .map(index -> FoodCategory.values()[index - 1].getName()).collect(Collectors.toList());
        return ResultFormatter.makeResultWithTitle(CATEGORY, days);
    }

    public String getSelectionResult(CoachGroup coachGroup) {
        StringBuilder resultBuilder = new StringBuilder();
        for (Coach coach : coachGroup.getCoaches()) {
            List<String> foods = selectFoods(coachGroup);
            resultBuilder.append(ResultFormatter.makeResultWithTitle(coach.getName(), foods));
        }
        return resultBuilder.toString();
    }
}
