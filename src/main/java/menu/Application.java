package menu;

import menu.controller.MenuSelectManager;

public class Application {
    public static void main(String[] args) {
        MenuSelectManager menuSelectManager = new MenuSelectManager();
        menuSelectManager.run();
    }
}
