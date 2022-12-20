package project.models;

import project.ScreensManager;
import project.SystemData;
import project.screens.ErrorScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Match extends Model {
    private long date;
    private Stadium stadium;
    ArrayList<Goal> goals;

    private Team team1, team2;
    private Referee referee;

    public Match(String name, long date, Stadium stadium, Team team1, Team team2, Referee referee, ArrayList<Goal> goals) {
        super(name);
        this.date = date;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
        this.referee = referee;
        this.goals = goals;
    }

    public int getGoalsCount() {
        return goals.size();
    }

    @Override
    public String toString() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return "Match{" +
                "date=" + dt.format(new Date(date*1000)) +
                ", stadium=" + stadium.getName() +
                ", team1=" + team1.getName() +
                ", team2=" + team2.getName() +
                ", referee=" + referee.getName() +
                ", number of goals: " + getGoalsCount() +
                ", goals=" + goals +
                '}';
    }


    @Override
    public void editModel() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String currentDate = dt.format(new Date(getDate()*1000));
        System.out.println("Current Date: " + currentDate);

        System.out.println("Enter New Date in yyyy-MM-dd hh:mm format or type 'same' to keep the same: (" + currentDate + ")");
        String newDate = scanner.next();
        if (!newDate.equalsIgnoreCase("same")) {
            try {
                setDate(dt.parse(newDate).getTime()/1000);
            } catch (ParseException e) {
                System.out.println("Wrong Format");
            }
        }

        // Editing Stadium

        System.out.println("Current Stadium: " + getStadium());

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < SystemData.Stadiumlist.size(); i++) {
            str.append("\n").append("To Change to "+SystemData.Stadiumlist.get(i).getName() + " Choose " + i);
        }
        System.out.println(str);

        System.out.println("To Keep the same Choose "+SystemData.Stadiumlist.size());

        int inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > SystemData.Stadiumlist.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex < SystemData.Stadiumlist.size()) {
            setStadium(SystemData.Stadiumlist.get(inputIndex));
        }

        // Editing team1

        System.out.println("Current Team1: " + getTeam1());

        str = new StringBuilder();
        for (int i = 0; i < SystemData.league.getTeams().size(); i++) {
            str.append("\n").append("To Change to "+SystemData.league.getTeams().get(i).getName() + " Choose " + i);
        }
        System.out.println(str);

        System.out.println("To Keep the same Choose "+SystemData.league.getTeams().size());

        inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > SystemData.league.getTeams().size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex < SystemData.league.getTeams().size()) {
            setTeam1(SystemData.league.getTeams().get(inputIndex));
        }

        // Editing team2

        System.out.println("Current Team2: " + getTeam2());

        str = new StringBuilder();
        for (int i = 0; i < SystemData.league.getTeams().size(); i++) {
            str.append("\n").append("To Change to "+SystemData.league.getTeams().get(i).getName() + " Choose " + i);
        }
        System.out.println(str);

        System.out.println("To Keep the same Choose "+SystemData.league.getTeams().size());

        inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > SystemData.league.getTeams().size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex < SystemData.league.getTeams().size()) {
            setTeam2(SystemData.league.getTeams().get(inputIndex));
        }

        // Editing Referee

        System.out.println("Current Referee: " + getReferee());

        str = new StringBuilder();
        for (int i = 0; i < SystemData.Refereelist.size(); i++) {
            str.append("\n").append("To Change to "+SystemData.Refereelist.get(i).getName() + " Choose " + i);
        }
        System.out.println(str);

        System.out.println("To Keep the same Choose "+SystemData.Refereelist.size());

        inputIndex = -1;
        for (;;) {
            try {
                inputIndex = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ignored) { }
            break;
        }

        if (inputIndex == -1 || inputIndex > SystemData.Refereelist.size()) {
            ErrorScreen errorScreen = new ErrorScreen("Invalid Input", "Please try again");
            errorScreen.start();
            return;
        }

        if (inputIndex < SystemData.Refereelist.size()) {
            setReferee(SystemData.Refereelist.get(inputIndex));
        }

        setName(team1.getName()+" vs "+team2.getName());

        ScreensManager.goBack();
    }

    public long getDate() {
        return date;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Referee getReferee() {
        return referee;
    }


    public void setDate(long date) {
        this.date = date;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public static ArrayList<Match> TopThreeMatches(ArrayList<Match> allMatches) {
        ArrayList<Match> matches = new ArrayList<>(allMatches);
        ArrayList<Match> maxPlayers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Match match = maximumMatch(matches);
            for(int j = 0; j < matches.size(); j++){
                if(matches.get(j).getId() == match.getId()){
                    matches.remove(j);
                }
            }
            maxPlayers.add(match);
        }
        return maxPlayers;
    }
    public static Match maximumMatch(ArrayList<Match> allMatches){
        Match maxMatch = null;
        int maxGoal = 0;
        for (Match match : allMatches) {
            if(match.getGoalsCount() > maxGoal){
                maxGoal = match.getGoalsCount();
                maxMatch = match;
            }
        }
        return maxMatch;

    }
}
