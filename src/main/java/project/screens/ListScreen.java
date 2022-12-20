//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.ScreensManager;

import java.util.ArrayList;

public class ListScreen extends Screen {
    private final ArrayList<Screen> screens;

    public ListScreen(String title, String header, ArrayList<Screen> screens) {
        super(title, header);
        this.screens = screens;
    }

    @Override
    public void start() {
        super.start();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < screens.size(); i++) {
            str.append("\n").append(screens.get(i).getTitle() + " Choose "+i);
        }
        System.out.println(str);

        System.out.println("To Go Back "+screens.size());

        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > screens.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex == screens.size()) {
            ScreensManager.goBack();
            return;
        }

        screens.get(inputIndex).start();
    }
}
