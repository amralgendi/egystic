package project;


import project.screens.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {

    public static void main(String[] args) {

        Screen welcomeScreen = new ListScreen("", "Welcome to EGYSTIC"+
                "\nThe Egyptian League Management System ", new ArrayList<>(Arrays.asList(
                new SignUpScreen(),
                new SignInScreen(),
                new EndScreen()
        )));

        welcomeScreen.start();

//        for (; ; ) {
//            printhome();
//            //1st choice  : display / add edit delete  / report / quit
//            // 2nd choice  : Display options
//            // 3rd choice  : add or edit or deletess
//            Scanner Firstinput = new Scanner(System.in);
//            int firstchoice = Firstinput.nextInt();
//            if (firstchoice == 1) {
//                printDisplayScreen();
//                int SecondChoice = Firstinput.nextInt();
//                if (SecondChoice == 1) { // Match
//                    String Fourthchoice = Firstinput.next();
//                    System.out.println(Fourthchoice);
//                } else if (SecondChoice == 2) { //Team
//                    String Fifthchoice = Firstinput.next();
//
//                } else if (SecondChoice == 3) { //Player
//                    String Sixthchoice = Firstinput.next();
//                } else if (SecondChoice == 4) { //referee
//                    String Seventhchoice = Firstinput.next();
//                } else if (SecondChoice == 5) { //Stadium
//                    String Eightchoice = Firstinput.next();
//                } else if (SecondChoice == 6) { //home
//                    continue;
//                } else if (SecondChoice == 7) { // quit
//                    break;
//                } else {
//                    System.out.println("Invalid Input , Please Try again");
//                }
//
//
//            } else if (firstchoice == 2) { // add / delete/edit
//                printmodifyoptionsScreen();
//                int ThirdChoice = Firstinput.nextInt();
//                if (ThirdChoice == 1) {  // add
//
//                } else if (ThirdChoice == 2) {  //edit
//
//                } else if (ThirdChoice == 3) { // delete
//
//                } else if (ThirdChoice == 4) { //return to home
//                    continue;
//                } else if (ThirdChoice == 5) { //Quit
//                    break;
//                } else {
//                    System.out.println("Invalid Input , Please Try again");
//                }
//
//            } else if (firstchoice == 3) { //report
//
//            } else if (firstchoice == 4) { //quit
//                break;
//            } else {
//                System.out.println("Invalid Input , Please Try again");
//
//            }
//
//
//        }
    }
    // Screens
    // Method  to Print Home Screen
    public static void printhome(){
        printdash();
        System.out.println("                           Welcome to EGYSTIC"+
                "\n                The Egyptian League Management System "+
                "\n To Select display Choose 1  " +
                "\n To Select add/edit/delete Choose 2  " +
                "\n To Select Display Reports Choose 3  "+
                "\n To quit Choose 4");
        printdash();
        System.out.print("Type your choice here: ");
    }
    //Method  to print a dashed line
    public static void printdash(){
        System.out.println("-------------------------------------------------------------------------------------");
    }
    // Method to print the screen to display objects
    public static void printDisplayScreen(){
        printdash();
        System.out.println("                          WHAT DO YOU WANT TO DISPLAY ? "+
                "\n To  Display Match Choose 1  " +
                "\n To  Display Team Choose 2  " +
                "\n To  Display Player in a team Choose 3  "+
                "\n To  Display Referee Choose 4 " +
                "\n To  Display Referee Choose 5 " +
                "\n To  Return to Home  Choose 6 "+
                "\n To  Quit Choose 7 ");
        printdash();
        System.out.print("Type your choice here: ");
    }
    // method to display modify options
    public static void printmodifyoptionsScreen(){
        printdash();
        System.out.println("                          WHAT Modifying Options Do you want ?? "+
                "\n To  add Choose 1  " +
                "\n To  edit Choose 2  " +
                "\n To  Delete Player  Choose 3  "+
                "\n To  Return to Home  Choose 4"+
                "\n To  Quit Choose 5 ");
        printdash();
        System.out.print("Type your choice here: ");
    }
}
