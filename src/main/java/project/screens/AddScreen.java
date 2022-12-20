package project.screens;

import project.ScreensManager;
import project.SystemData;
import project.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddScreen  extends Screen{
    private final ArrayList<Class> models = new ArrayList<>(Arrays.asList(Team.class, Match.class, Referee.class, Stadium.class));
    public AddScreen() {
        super("Add Screen", "Choose Model to add");
    }
    public void start() {
        super.start();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < models.size(); i++) {
            str.append("\n").append(models.get(i).getSimpleName() + " Choose " + i);
        }
        System.out.println(str);

        System.out.println("To Go Back "+models.size());

        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > models.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex == models.size()) {
            ScreensManager.goBack();
            return;
        }

        Class modelPicked = models.get(inputIndex);
        if(modelPicked == Team.class) {
            addTeam();
        } else if(modelPicked == Match.class){
            addMatch();
        } else if(modelPicked == Referee.class){
            addReferee();
        } else if(modelPicked == Stadium.class){
            addStadium();
        }
    }
    private void addTeam(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Enter Team Name:");
        String name = scanner.next();

        System.out.println("How many Players do you want to add:");
        int playersCount = scanner.nextInt();
        ArrayList playerList = new ArrayList();
        for(int i = 0; i < playersCount; i++) {
            System.out.println("Enter Player Name:");
            String playerName = scanner.next();
            System.out.println("Enter Player Weight:");
            float weight = scanner.nextFloat();
            System.out.println("Enter Player Height:");
            float height = scanner.nextFloat();
            System.out.println("Enter Player Position:");
            String position = scanner.next();
            playerList.add(new Player(playerName, height, weight, position));
        }
        Team newTeam = new Team(name, playerList);
        SystemData.league.addTeam(newTeam);
        System.out.println("Team Added");
        doneAdding();
    }
    private void addMatch(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        System.out.println("Enter Date in yyyy-MM-dd hh:mm format:");
        long date = 1651346295;
        String newDate = scanner.next();
        if (!newDate.equalsIgnoreCase("same")) {
            try {
                date = dt.parse(newDate).getTime()/1000;
            } catch (ParseException e) {
                System.out.println("Wrong Format");
            }
        }
        System.out.println("Choose Team 1:");
        Team team1 = pickTeam(null);
        System.out.println("Choose Team 2:");
        Team team2 = pickTeam(team1);
        System.out.println("Choose Stadium:");
        Stadium stadium = pickStadium();
        System.out.println("Choose Referee:");
        Referee referee = pickReferee();
        System.out.println("How many goals:");
        int goalCount = scanner.nextInt();
        ArrayList<Goal> goals = new ArrayList<>();
        for(int i = 0; i < goalCount; i++) {
            int j = i + 1;
            System.out.println("Goal number: " + j);
            String playerId = pickPlayer(team1, team2).getId();
            System.out.println("Enter time of goal using the form mm:ss");
            String time = scanner.next();
            goals.add(new Goal(playerId, time));
        }
        Match newMatch = new Match(team1.getName() + " vs " + team2.getName(), date, stadium, team1, team2, referee, goals);
        SystemData.MatchList.add(newMatch);
        System.out.println("Match Added");
        doneAdding();
    }
    private void addReferee(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Enter Referee Name:");
        String name = scanner.next();
        System.out.println("Enter Referee Weight:");
        float weight = scanner.nextFloat();
        System.out.println("Enter Referee Height:");
        float height = scanner.nextFloat();
        Referee newReferee = new Referee(name, height, weight);
        SystemData.Refereelist.add(newReferee);
        System.out.println("Referee Added");
        doneAdding();
    }
    private void addStadium(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Enter Stadium Name:");
        String name = scanner.next();
        System.out.println("Enter Stadium Location:");
        String location = scanner.next();
        System.out.println("Enter Stadium Capacity:");
        int capacity = scanner.nextInt();
        Stadium newStadium = new Stadium(name, location, capacity);
        SystemData.Stadiumlist.add(newStadium);
        System.out.println("Stadium Added");
        doneAdding();
    }
    private void doneAdding() {
        ListScreen screen = new AdminScreen();
        screen.start();
    }
    private Team pickTeam(Team excludedTeam) {
        ArrayList<Team> teams = new ArrayList<>(SystemData.league.getTeams());
        if(excludedTeam != null) {
            teams.remove(excludedTeam);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < teams.size(); i++) {
            str.append("\n").append(teams.get(i).getName() + " Choose "+i);
        }
        System.out.println(str);


        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > teams.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return null;
        }

        return teams.get(inputIndex);
    }
    private Player pickPlayer(Team team1, Team team2){
        StringBuilder str = new StringBuilder();
        str.append(team1.getName() + " Choose " + 0 + '\n');
        str.append(team2.getName() + " Choose " + 1 );
        System.out.println(str);
        Scanner scanner = new Scanner(System.in);
        int teamPick = scanner.nextInt();
        Team selectedTeam;
        ArrayList<Player> players;
        if(teamPick == 0) {
            selectedTeam =  team1;
        }else if(teamPick == 1) {
            selectedTeam =  team2;
        } else {
            System.out.println("Please choose a number within the shown above.");
            return pickPlayer(team1, team2);
        }
        System.out.println("Choose a player from team: " + selectedTeam.getName());
        players = new ArrayList<>(selectedTeam.getPlayerList());
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            str1.append("\n").append(players.get(i).getName() + " Choose " + i);
        }
        System.out.println(str1);


        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > players.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return null;
        }

        return players.get(inputIndex);

    }
    private Stadium pickStadium() {
        ArrayList<Stadium> stadiums = SystemData.Stadiumlist;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < stadiums.size(); i++) {
            str.append("\n").append(stadiums.get(i).getName() + " Choose "+i);
        }
        System.out.println(str);


        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > stadiums.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return null;
        }

        return stadiums.get(inputIndex);
    }
    private Referee pickReferee() {
        ArrayList<Referee> referees = SystemData.Refereelist;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < referees.size(); i++) {
            str.append("\n").append(referees.get(i).getName() + " Choose "+i);
        }
        System.out.println(str);


        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(getInput());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > referees.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return null;
        }

        return referees.get(inputIndex);
    }
}
