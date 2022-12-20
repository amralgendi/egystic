//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import project.ScreensManager;

import java.util.Scanner;

abstract public class Screen {
    private String title;
    private String header;

    public Screen(String title, String header) {
        this.title = title;
        this.header = header;
    }

    public void start() {
        System.out.println("");
        System.out.println(title);
        if (header.length() > 0) {
            System.out.println(header);
        }
        System.out.println("-------------------------------------------------------------------------------------");
        ScreensManager.addNewScreen(this);
    }

    public String getInput() {
        Scanner inputScanner = new Scanner(System.in);
        String inputStr = inputScanner.next();

//        if (inputStr.equals("/back")) {
//            ScreensManager.goBack();
//            return "";
//        }

        return inputStr;
    }


    public String getHeader() {
        return header;
    }

    public String getTitle() {
        return title;
    }
}
