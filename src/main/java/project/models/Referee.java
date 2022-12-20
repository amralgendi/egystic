package project.models;

import project.ScreensManager;
import project.SystemData;

import java.util.ArrayList;

public class Referee extends Person {

    public Referee(String name, float height, float weight) {
        super(name, height, weight);
    }

    public ArrayList<Match> getMatches() {
        ArrayList<Match> arr = new ArrayList<>();
        for (Match match : SystemData.MatchList) {
               if(match.getReferee().getId().equals(this.getId())){
                   arr.add(match);
               }
        }
        return arr;

    }

    @Override
    public void editModel() {
        super.editModel();
        ScreensManager.goBack();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Referee{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", matches{ ");
        if (getMatches().size() == 0) {
            str.append("None, ");
        }
        for (Match match : getMatches()) {
            str.append(match.getName());
            str.append(", ");
        }
        str.delete(str.length() - 2, str.length());
        str.append(" }");
        return str.toString();

    }
}
