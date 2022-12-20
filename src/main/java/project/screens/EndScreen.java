//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.ScreensManager;

public class EndScreen extends Screen {
    public EndScreen() {
        super("Quit", "Thank You for using our system.");
    }

    @Override
    public void start() {
        super.start();
        ScreensManager.quit();
    }
}
