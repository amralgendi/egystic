package project;

import project.screens.AdminScreen;
import project.screens.Screen;

import java.util.ArrayList;

public class ScreensManager {
    public static ArrayList<Screen> shownScreens = new ArrayList<>();

    public static void addNewScreen(Screen screen) {
        shownScreens.add(screen);
    }

    public static void goBack() {
        if (shownScreens.size() < 2) {
            return;
        }
        shownScreens.remove(shownScreens.size()-1);
        shownScreens.get(shownScreens.size()-1).start();
    }

    public static void quit() {
        if (shownScreens.size() == 0) {
            return;
        }
        shownScreens.remove(shownScreens.size()-1);
    }

    public static void backToAdminScreen() {
        shownScreens.clear();
        AdminScreen adminScreen = new AdminScreen();
        adminScreen.start();
    }
}
