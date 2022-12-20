//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.AdminsData;

import java.util.ArrayList;
import java.util.Arrays;

public class SignInScreen extends Screen {
    public SignInScreen() {
        super("Sign In", "");
    }

    @Override
    public void start() {
        super.start();

        System.out.println("Please Enter Your email: ");
        String email = getInput();
        System.out.println("Please Enter Your password: ");
        String password = getInput();

        if (AdminsData.login(email, password) != null) {

            Screen welcomeScreen = new AdminScreen();
            welcomeScreen.start();
        }else {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Creds", "Please check for the data entered and try again.");
            errorScreen.start();
        }
    }
}
