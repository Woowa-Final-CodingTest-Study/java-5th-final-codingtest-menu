package menu.controller;

import menu.domain.DayOfWeekRecommend;
import menu.domain.RecommendMenus;
import menu.domain.UnPreferredMenus;

public class RecommendController {

    DayOfWeekRecommend dayOfWeekRecommend = new DayOfWeekRecommend();

    public RecommendMenus requestWeekCommend(RecommendMenus recommendMenus, UnPreferredMenus unPreferredMenus) {
        RecommendMenus weekRecommendMenus = dayOfWeekRecommend.generateWeekRecommend(recommendMenus, unPreferredMenus);

        return weekRecommendMenus;
    }
}
