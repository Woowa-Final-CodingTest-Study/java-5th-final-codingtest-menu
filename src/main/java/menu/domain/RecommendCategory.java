package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.MenuCategory;

public class RecommendCategory {

    public String generateRecommendCategory() {
        int categoryNumber = 0;
        while(true) {
            categoryNumber = Randoms.pickNumberInRange(1, 5);

            if(checkRecommendCategoryCount(categoryNumber)) {
                break;
            }
        }
        return MenuCategory.findByCategory(categoryNumber);
    }

    public boolean checkRecommendCategoryCount(int categoryNumber) {
            for(MenuCategory menuCategory : MenuCategory.values()) {
                if(menuCategory.getCategoryNumber()==categoryNumber && menuCategory.getCategoryCount() < 2) {
                    menuCategory.countCategory();
                    return true;
                }
            }
            return false;
    }
}
