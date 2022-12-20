package project.screens;

import project.ScreensManager;
import project.SystemData;
import project.models.Admin;
import project.models.Model;

import java.util.ArrayList;

public class ListDataScreen extends Screen{
    private final ArrayList<Model> data;
    private Class classType;

    public ListDataScreen(String title, String header, ArrayList<Model> data, Class classType) {
        super(title, header);
        this.data = data;
        this.classType = classType;
    }

    @Override
    public void start() {
        super.start();
        StringBuilder str = new StringBuilder();

        if (data.size() == 0) {
            System.out.println("No "+classType.getSimpleName()+"s Available");
            ScreensManager.backToAdminScreen();
            return;
        }

        for (int i = 0; i < data.size(); i++) {
            str.append("\n").append(data.get(i).getName() + " Choose "+ i);
        }
        System.out.println(str);

        System.out.println("To Go Back "+data.size());

        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > data.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex == data.size()) {
            ScreensManager.goBack();
            return;
        }

        data.get(inputIndex).displayInfo();
        System.out.println("To Edit Choose 0");
        System.out.println("To Delete Choose 1");
        System.out.println("To Go Back 2");

        String input = getInput();
        if (input.equals("0")) {
            data.get(inputIndex).editModel();
        }else if (input.equals("1")) {
            SystemData.deleteObject(data.get(inputIndex));
            System.out.println(data.get(inputIndex).getName()+" deleted successfully");
            new AdminScreen().start();
        }else if (input.equals("2")) {
            ScreensManager.goBack();
        }

    }
}
