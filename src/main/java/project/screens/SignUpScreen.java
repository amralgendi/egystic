//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.models.Admin;
import project.AdminsData;
import project.ScreensManager;

public class SignUpScreen extends DataCreationScreen {
    public SignUpScreen() {
        super("Sign Up", "", Admin.class);
    }

    @Override
    void dataInputted(Object object) {
        AdminsData.addNewAdmin((Admin) object);
        ScreensManager.goBack();
    }
}
