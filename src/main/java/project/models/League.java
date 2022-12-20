package project.models;

import java.util.ArrayList;

public class League extends Model {
    private long startDate, endDate;
    private ArrayList<Team> teams;
    public League(String name, long startDate, long endDate, ArrayList<Team> teams) {
        super(name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.teams = teams;
    }

    public ArrayList<Match> getMatches() {
        return null;
    }

    @Override
    public String toString() {
        return "League{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", teams=" + teams +
                '}';
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
}
