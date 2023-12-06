package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RecommendMenus {

    private final List<RecommendMenu> recommendMenus;

    public RecommendMenus(List<RecommendMenu> recommendMenus) {
        this.recommendMenus = recommendMenus;
    }

    public List<RecommendMenu> getRecommendMenus() {
        return recommendMenus;
    }
}
