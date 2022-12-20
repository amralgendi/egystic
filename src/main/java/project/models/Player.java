package project.models;

import project.ScreensManager;
import project.SystemData;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {
    private String position;
    private String teamId;
    private ArrayList<Goal> goals = new ArrayList<>();
    public Team getTeam() {
        for (Team team : SystemData.league.getTeams()) {
            if(team.getId().equals(this.teamId)){
                return team;
            }
        }
        return null;
    }
    public void addGoal(Goal goal) {
        goals.add(goal);
    }
    public int getGoalCount() { return goals.size(); }
    public Player(String name, float height, float weight, String position) {
        super(name, height, weight);
        this.position = position;
    }

    @Override
    public String toString() {

        return "Player{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", number of goals: " + getGoalCount() +
                ", team: " + getTeam().getName() +
                '}';
    }

    @Override
    public void editModel() {
        super.editModel();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.println("Enter Position or type 'same' to keep the same: (" + getPosition() + ")");
        String newPosition = scanner.next();
        if (!newPosition.equalsIgnoreCase("same")) {
            setPosition(newPosition);
        }

        ScreensManager.goBack();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void finalizePlayer(Team team) {
        this.teamId = team.getId();
    }
    public static ArrayList<Player> TopThreePlayers(ArrayList<Player> allPlayers) {
        ArrayList<Player> players = new ArrayList<>(allPlayers);
        ArrayList<Player> maxPlayers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Player player = maximumPlayer(players);
            for(int j = 0; j < players.size(); j++){
                if(players.get(j).getId() == player.getId()){
                    players.remove(j);
                }
            }
            maxPlayers.add(player);
        }
        return maxPlayers;
    }
    public static Player maximumPlayer(ArrayList<Player> allPlayers){
        Player maxPlayer = null;
        int maxGoal = 0;
        for (Player player : allPlayers) {
            if(player.getGoalCount() > maxGoal){
                maxGoal = player.getGoalCount();
                maxPlayer = player;
            }
        }
        return maxPlayer;

    }
}
