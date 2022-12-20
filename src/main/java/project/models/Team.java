package project.models;

import project.ScreensManager;
import project.SystemData;
import project.screens.ErrorScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team extends Model {
    private ArrayList<Player> playerList;

    public Team(String name, List<Player> playerList) {
        super(name);
        this.playerList = new ArrayList(playerList);
        for (Player player : playerList) {
            player.finalizePlayer(this);
            SystemData.PlayerList.add(player);
        }

    }
    public Team(String name) {
        super(name);
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", playerList=" + playerList +
                '}';
    }

    @Override
    public void editModel() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Enter Name or type 'same' to keep the same: (" + getName() + ")");
        String newName = scanner.next();
        if (!newName.equalsIgnoreCase("same")) {
            setName(newName);
        }
        if (playerList.size() == 0) {
            ScreensManager.goBack();
            return;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < playerList.size(); i++) {
            str.append("\n").append("To Edit "+playerList.get(i).getName() + " Choose " + i);
        }
        System.out.println(str);
        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > playerList.size()-1) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        Player selectedPlayer = playerList.get(inputIndex);

        System.out.println(selectedPlayer);
        System.out.println("To Edit Player Choose 0");
        System.out.println("To Delete Player Choose 1");
        System.out.println("To Go back Choose 2");

        String input = scanner.next();

        if (input.equals("0")) {
            selectedPlayer.editModel();
        }else if (input.equals("1")) {
            SystemData.deleteObject(selectedPlayer);
            ScreensManager.goBack();
        }else {
            ScreensManager.goBack();
        }

    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
