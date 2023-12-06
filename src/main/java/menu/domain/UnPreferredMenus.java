package menu.domain;

import java.util.Collections;
import java.util.List;

public class UnPreferredMenus {

    private final List<UnPreferredMenu> unPreferredMenus;

    public UnPreferredMenus(List<UnPreferredMenu> unPreferredMenus) {
        this.unPreferredMenus = Collections.unmodifiableList(unPreferredMenus);
    }

    public List<UnPreferredMenu> getUnPreferredMenus() {
        return unPreferredMenus;
    }

    public static UnPreferredMenu findCoachUnPreferredMenu(String coachName, UnPreferredMenus unPreferredMenus) {
        for(UnPreferredMenu unPreferredMenu : unPreferredMenus.getUnPreferredMenus()) {
            if(unPreferredMenu.getCoachName().equals(coachName)) {
                return unPreferredMenu;
            }
        }
        throw new IllegalArgumentException();
    }
}
