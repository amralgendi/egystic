package project.screens;

import project.SystemData;
import project.models.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ModifyScreen extends  ListScreen{
    public ModifyScreen() {
        super("Modify Screen", "", new ArrayList<>(Arrays.asList(
                new ListDataScreen("Teams", "All Teams in league are displayed. Please choose one: ", new ArrayList<>(SystemData.league.getTeams()), Team.class),
                new ListDataScreen("Matches", "All Matches are displayed. Please choose one:", new ArrayList<>(SystemData.MatchList), Match.class),
                new ListDataScreen("Referees", "All Referees are displayed. Please choose one:", new ArrayList<>(SystemData.Refereelist), Referee.class),
                new ListDataScreen("Stadiums", "All Stadiums are displayed. Please choose one:", new ArrayList<>(SystemData.Stadiumlist), Stadium.class)
        )));
    }
}
