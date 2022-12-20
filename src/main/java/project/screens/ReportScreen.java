package project.screens;

import project.SystemData;
import project.models.League;
import project.models.Match;
import project.models.Player;
import project.models.Team;

import java.util.ArrayList;

public class ReportScreen extends Screen{

    public ReportScreen() {
        super("Report", "");
    }

    @Override
    public void start(){
        StringBuilder str = new StringBuilder();
        League league = SystemData.league;
        str.append("League name: ").append(league.getName()).append("\n started at ").append(league.getStartDate()).append(('\n'));
        str.append("Total matches: ").append(SystemData.MatchList.size()).append('\n');
        ArrayList<Team> allTeams = SystemData.league.getTeams();
        str.append("Total Teams: ").append(allTeams.size()).append('\n');
        str.append("List of teams:\n");
        for(Team team : allTeams) {
            str.append("\t\t").append(team).append('\n');
        }
        ArrayList<Match> bestMatches = Match.TopThreeMatches(SystemData.MatchList);
        str.append("Top three Matches:\n");
        for (Match bestMatch : bestMatches) {
            str.append("\t\t").append(bestMatch).append('\n');
        }
        ArrayList<Player> bestPlayers = Player.TopThreePlayers(SystemData.PlayerList);
        str.append("Top three Players:\n");
        for (Player bestPlayer : bestPlayers) {
            str.append("\t\t").append(bestPlayer).append('\n');
        }

        System.out.println(str);

        new AdminScreen().start();


    }
}
