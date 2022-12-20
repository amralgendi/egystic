package project.models;

import project.SystemData;

public class Goal extends Model{
    private String playerId;
    private String matchId;
    private String time;
    public Goal(String playerId, String time){
        super(null);
        this.playerId = playerId;
        this.time = time;
        getPlayer().addGoal(this);
    }
    public Player getPlayer(){
        for (Player player : SystemData.PlayerList) {
            if(player.getId().equals(this.playerId)) {
                return player;
            }
        }
        System.out.println("Can't find player");
        return null;
    }
    public Match getMatch(){
        for (Match match : SystemData.MatchList) {
            if(match.getId().equals(this.matchId)) {
                return match;
            }
        }
        return null;
    }
    public String getTime(){return time;}
    @Override
    public String toString() {
        return "Goal by: " + getPlayer().getName() + "at " + getTime();
    }
}
