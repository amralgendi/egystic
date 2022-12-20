//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.ScreensManager;

public class ErrorScreen extends Screen {
    public ErrorScreen(String errorTitle, String errorBody) {
        super(errorTitle, errorBody);
    }
    @Override
    public void start() {
        super.start();
        ScreensManager.goBack();
    }
}
