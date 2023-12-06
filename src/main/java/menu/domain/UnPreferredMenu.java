package menu.domain;

import java.util.List;

public class UnPreferredMenu {
    private String coach;
    private List<String> unPreferredMenu;

    public UnPreferredMenu(String coach, List<String> unPreferredMenu) {
        this.coach = coach;
        this.unPreferredMenu = unPreferredMenu;
    }

    public String getCoachName() {
        return coach;
    }

    public boolean checkUnPreferredMenus(String recommendMenu) {
        if(unPreferredMenu.contains(recommendMenu)) {
            return true;
        }
        return false;
    }
}
