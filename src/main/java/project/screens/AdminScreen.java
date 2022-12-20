package project.screens;

import project.AdminsData;

import java.util.ArrayList;
import java.util.Arrays;

public class AdminScreen extends ListScreen{

    public AdminScreen() {
        super("Admin Panel", "Welcome " + AdminsData.getCurrentUser().getEmail() + ", Please pick an action", new ArrayList<>(Arrays.asList(
                new AddScreen(),
                new ModifyScreen(),
                new ReportScreen(),
                new EndScreen()
        )));
    }
}
