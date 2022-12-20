//
//  SystemData.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project;

import project.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SystemData {
    static public ArrayList<Admin> admins = new ArrayList();
    static public ArrayList<Player> PlayerList = new ArrayList<>();

    static private ArrayList<Team> Teamlist = new ArrayList<>(List.of(
            new Team("Zamalek",  List.of(
                    new Player("Ahmed Amin", 1.82f, 46 ,"Attack"),
                    new Player("Abdullah Adel", 1.72f, 61 ,"Midfield"),
                    new Player("Abdel Rahman", 1.72f, 77 ,"Defence"),
                    new Player("Ahmed Samir", 1.89f, 90 ,"Midfield"),
                    new Player("Mohamed Sherif", 1.84f, 80,"Attack"),
                    new Player("Eric Traor�", 1.82f, 85 ,"Attack"),
                    new Player("Ahmed Dahroug", 1.72f, 42 ,"Defence"),
                    new Player("Ramadan Sobhi", 1.89f, 75 ,"Midfield"),
                    new Player("Moustafa Gamal", 1.78f, 85 ,"Midfield"),
                    new Player("Ziadfarag", 1.82f, 30 ,"Attack"),
                    new Player("Judy Dinopter", 1.78f, 67 ,"Attack"))),
            new Team("Al Ahly",  List.of(
                    new Player("Obama", 1.75f, 84,"Attack"),
                    new Player("Mohamed Nagieb", 1.82f, 74 ,"Defence"),
                    new Player("Ahmed Mohsen", 1.72f, 74 ,"Defence"),
                    new Player("Mohanad Lasheen", 1.90f, 76 ,"Midfield"),
                    new Player("Omar El Wahsh", 1.89f, 76 ,"Midfield"),
                    new Player("Kamal ElSayed", 1.82f, 76 ,"Goalkeeper"),
                    new Player("Mohamed Magdi Kafsha", 1.68f, 46 ,"Midfield"),
                    new Player("Winful Cobbinah", 1.78f, 46 ,"Midfield"),
                    new Player("Carmelo Algara�az", 1.90f, 81 ,"Attack"),
                    new Player("Mohamed Shawky Gharib", 1.90f, 90 ,"Defence"),
                    new Player("Mohamed Samir", 1.82f, 84,"Defence"))),
            new Team("PyramidsfC",  List.of(
                    new Player("Mohamed fakhri", 1.85f, 66 ,"Midfield"),
                    new Player("Masahudu Alhassan", 1.72f, 73 ,"Defence"),
                    new Player("Ali Gabr", 1.93f, 85 ,"Defence"),
                    new Player("Beltagy Samir", 1.72f, 140 ,"Goalkeeper"),
                    new Player("Osamafaisal", 1.72f, 72 ,"Attack"),
                    new Player("Ahmed Adel Elkalamawy", 1.78f, 90,"Midfield"),
                    new Player("Saif El Agouz", 1.90f, 80,"Midfield"),
                    new Player("Mohamed Bayomi", 1.82f, 70 ,"Midfield"),
                    new Player("Ahmed Sayed", 1.74f, 78 ,"Attack"),
                    new Player("John Antwi", 1.90f, 71 ,"Attack"),
                    new Player("Ahmed Abdelaziz", 1.78f, 85 ,"Defence"))),
            new Team("Smouha",  List.of(new Player("Ahmed Rashed", 1.72f, 70 ,"Midfield"), new Player("Mohamed�Ashraf", 1.78f, 80,"Goalkeeper"), new Player("Akram Tawfik", 1.77f, 79 ,"Midfield"), new Player("Nabil Emad Dunga", 1.76f, 90 ,"Midfield"), new Player("Ragab Al Safy", 1.90f, 90,"Midfield"), new Player("Mohamed�Nadi", 1.82f, 90,"Defence"), new Player("Louay Wael Mohamed Badr", 1.72f, 58 ,"Defence"), new Player("Ahmed Khaled", 1.90f, 180 ,"Midfield"), new Player("Ahmed�Nabil", 1.82f, 90,"Midfield"), new Player("Mohamed Mahmoud", 1.65f, 51 ,"Midfield"), new Player("Hosam Hassan", 1.72f, 80,"Midfield"))),
            new Team("Al Masry",  List.of(new Player("Amir Ismail", 1.72f, 13 ,"Midfield"), new Player("Saif El Agouz", 1.90f, 80,"Midfield"), new Player("Mohamed Hassan", 1.82f, 80,"Midfield"), new Player("Mohamed Sherif", 1.84f, 80,"Attack"), new Player("Mahmoud Atef", 1.72f, 70,"Defence"), new Player("Ahmed Kase", 1.72f, 84,"Midfield"), new Player("Abdallah Magdy", 1.72f, 76 ,"Attack"), new Player("Abdelrehman Khaled", 1.82f, 84,"Attack"), new Player("Tarek Samy", 1.78f, 66 ,"Defence"), new Player("Hossam Ashour", 1.78f, 67 ,"Midfield"), new Player("Ahmed Kase", 1.72f, 84,"Midfield"))),
            new Team("ENPPI",  List.of(new Player("Mohamed Shehata", 1.78f, 69 ,"Goalkeeper"), new Player("Omar�Salah", 1.89f, 76 ,"Goalkeeper"), new Player("Mohamed Magdy", 1.72f, 130 ,"Goalkeeper"), new Player("Ahmed�Fatouh", 1.75f, 78 ,"Defence"), new Player("Khaled Mohamed Awad", 1.72f, 80,"Defence"), new Player("Badr Benoun", 1.93f, 79 ,"Defence"), new Player("Arnaud Randrianantenaina", 1.78f, 75 ,"Attack"), new Player("Ragab Al Safy", 1.90f, 90,"Midfield"), new Player("Justinian Mabolo", 1.89f, 54 ,"Attack"), new Player("Austin Amutu", 1.82f, 74 ,"Defence"), new Player("Karim El Eraki", 1.89f, 74 ,"Defence"))),
            new Team("Al Ittihad",  List.of(new Player(" Mahmoud El Gharabawy", 1.78f, 31 ,"Goalkeeper"), new Player("Mohamed�Abdel-Shafy", 1.75f, 77 ,"Defence"), new Player("Ahmed El-Sayed", 1.78f, 84,"Midfield"), new Player("Beltagy Samir", 1.72f, 140 ,"Goalkeeper"), new Player("Akram Tawfik", 1.77f, 79 ,"Midfield"), new Player("Mohamedfakhri", 1.85f, 66 ,"Midfield"), new Player("Eric Traor�", 1.82f, 85 ,"Attack"), new Player("Mohamed Grendo", 1.90f, 80,"Attack"), new Player("Hatem Mohammed", 1.84f, 84,"Defence"), new Player("Omar Gaber", 1.74f, 71 ,"Midfield"), new Player("David Cameron", 1.72f, 67 ,"Attack"))),
            new Team("Tala'ea El Gaish",  List.of(new Player("Ahmed Masoud", 1.90f, 90,"Goalkeeper"), new Player("Eric Traor�", 1.82f, 85 ,"Attack"), new Player("Boateng Benjamin Bernard", 1.82f, 66 ,"Attack"), new Player("Ahmed Ayman Mansour", 1.78f, 85 ,"Defence"), new Player("Mohamed Eldarf", 1.72f, 80,"Midfield"), new Player("Baher El Mohamadi", 1.72f, 67 ,"Defence"), new Player("Kazadi Kasengu", 1.90f, 68 ,"Attack"), new Player("Hussam�Ashraf", 1.73f, 84,"Midfield"), new Player("Haytham Mostafa", 1.72f, 138 ,"Midfield"), new Player("Hussein�Faisal", 1.72f, 77 ,"Midfield"), new Player("Ahmed El Sayed Ghabrib", 1.90f, 74 ,"Attack"))),
            new Team("Arab Contractors",  List.of(new Player("Ahmed Samy", 1.84f, 90 ,"Defence"), new Player("Abdo Yahya", 1.82f, 54 ,"Attack"), new Player("Marwan El Nagar", 1.89f, 67 ,"Defence"), new Player("Mohamed Abdelsala", 1.82f, 78 ,"Defence"), new Player("Tarek Hamed", 1.69f, 67 ,"Midfield"), new Player("Mohamad Samir", 1.72f, 77 ,"Midfield"), new Player("Khaled El Husseini", 1.90f, 80 ,"Defence"), new Player("Ashraf El Sayed", 1.90f, 78 ,"Midfield"), new Player("Karim Tarek", 1.78f, 79 ,"Midfield"), new Player("Aliou Dieng", 1.79f, 78 ,"Midfield"), new Player("Tarek Hagag", 1.82f, 69 ,"Attack"))),
            new Team("Ceramica CleopatrafC",  List.of(new Player("Marwan Attia", 1.89f, 86 ,"Midfield"), new Player("Baha Magdi�Hassan", 1.78f, 80,"Defence"), new Player("Abdelkabir�Elouadi", 1.82f, 90,"Attack"), new Player("Ahmed El Sudany", 1.89f, 85 ,"Midfield"), new Player("Khaled�Abdelfatta", 1.72f, 78 ,"Defence"), new Player("Key Patter", 1.89f, 90,"Attack"), new Player("Mohamed Gaber", 1.72f, 76 ,"Midfield"), new Player("Moaz El Henawy", 1.78f, 84,"Defence"), new Player("Ibrahim Mostafa", 1.82f, 79 ,"Defence"), new Player("Nabil Emad Dunga", 1.76f, 90 ,"Midfield"), new Player("Mohamed Hamdy", 1.74f, 76 ,"Defence"))),
            new Team("Misr El Makkasa",  List.of(new Player("Khaled El Ghandor", 1.72f, 84,"Midfield"), new Player("Ahmed Ghonei", 1.78f, 70 ,"Attack"), new Player("Ahmed Sayed", 1.74f, 78 ,"Attack"), new Player("Hatem Mohammed", 1.84f, 84,"Defence"), new Player("Ahmed Khaled", 1.90f, 180 ,"Midfield"), new Player("Khaled Stouhi", 1.90f, 70,"Defence"), new Player("Mohamad Samir", 1.72f, 77 ,"Midfield"), new Player("Khaled El Ghandor", 1.72f, 84,"Midfield"), new Player("Abdelrahman�Amer", 1.72f, 84,"Attack"), new Player("Mohamed Nagieb", 1.82f, 74 ,"Defence"), new Player("Mohamed Mouhsen", 1.72f, 69 ,"Midfield"))),
            new Team("El GounafC",  List.of(new Player("Abdelrahman�Amer", 1.72f, 84,"Attack"), new Player("Islam Abou- Salima", 1.72f, 90,"Defence"), new Player("Ammar Hamdy", 1.68f, 62 ,"Midfield"), new Player("Yehia Zakaria", 1.72f, 67 ,"Midfield"), new Player("Fares Hate", 1.72f, 78 ,"Defence"), new Player("Islam Serry", 1.72f, 76 ,"Midfield"), new Player("Mohamed Sharif Mohamed", 1.72f, 84,"Midfield"), new Player("Ossama Ramadani", 1.72f, 79 ,"Defence"), new Player("Mohamed Jamal Bebo", 1.89f, 79 ,"Defence"), new Player("Mohamed Hassan", 1.82f, 80,"Midfield"), new Player("Ahmed Mohamed Sale", 1.89f, 67 ,"Attack"))),
            new Team("Ismaily",  List.of(new Player("Abubakar�Liday", 1.89f, 78 ,"Attack"), new Player("Mohamed Essa", 1.72f, 70,"Attack"), new Player("Maarouf Yussuf", 1.90f, 84,"Midfield"), new Player("Khaled Mohamed Awad", 1.72f, 80,"Defence"), new Player("Taha Juma", 1.82f, 80 ,"Midfield"), new Player("Ismail El Leithy", 1.81f, 80,"Midfield"), new Player("Jean Morel Po�", 1.72f, 84,"Attack"), new Player("Mostafa El Zenary", 1.90f, 67 ,"Defence"), new Player("Mohamed Rizk", 1.72f, 80,"Midfield"), new Player("Mohamed Ashraf", 1.91f, 90,"Defence"), new Player("Youssef Osama Nabih", 1.69f, 84,"Midfield"))),
            new Team("Ghazl Al-Mehalla",  List.of(new Player("Taher Mohamed", 1.86f, 79 ,"Midfield"), new Player("Mohamed Shawky Gharib", 1.90f, 90 ,"Defence"), new Player("Khaled Gamal", 1.72f, 70,"Midfield"), new Player("Ahmed Sherweda", 1.89f, 84,"Attack"), new Player("Islam Salah", 1.78f, 54 ,"Defence"), new Player("Jerome�Philip", 1.72f, 84,"Attack"), new Player("Sherif Ekramy", 1.91f, 93 ,"Goalkeeper"), new Player("Ibrahim Mostafa", 1.82f, 79 ,"Defence"), new Player("Hesham Adel", 1.78f, 90 ,"Defence"), new Player("Atahir El Tahir�Babikir Mohamed", 1.82f, 90,"Defence"), new Player("Mohamed Al-Shenawi1.91", 1.91f, 86 ,"Goalkeeper"))),
            new Team("National Bank",  List.of(new Player("Hatem Gamil Awad", 1.78f, 84,"Midfield"), new Player("Amr Merhi", 1.89f, 76 ,"Attack"), new Player("Reda Amr", 1.90f, 77 ,"Attack"), new Player("Mahmoud Abdelkader", 1.82f, 34 ,"Defence"), new Player("Islam Adel", 1.72f, 76 ,"Midfield"), new Player("Wagih Abdelhaki", 1.82f, 80,"Attack"), new Player("Momen Ibrahi", 1.82f, 90 ,"Midfield"), new Player("Mohamed�Saeed", 1.78f, 67 ,"Midfield"), new Player("Ibrahim El Kadi", 1.72f, 90 ,"Defence"), new Player("Walid Mostafa", 1.90f, 69 ,"Defence"), new Player("Baha Magdi�Hassan", 1.78f, 80,"Defence"))),
            new Team("Aswan",  List.of(new Player("Saleh Nasr", 1.75f, 70,"Midfield"), new Player("Mahmoud Abdulaziz", 1.89f, 85 ,"Defence"), new Player("Kazadi Kasengu", 1.90f, 68 ,"Attack"), new Player("Hassan Yassin", 1.72f, 79 ,"Midfield"), new Player("Abdallah Mahmoud", 1.72f, 78 ,"Defence"), new Player("Mohamed Kamal", 1.90f, 84,"Midfield"), new Player("Ismail El Leithy", 1.81f, 80,"Midfield"), new Player("�Canaria", 1.89f, 68 ,"Midfield"), new Player("Ammar Mohamed", 1.90f, 67 ,"Defence"), new Player("Mohamed Ibrahi", 1.78f, 67 ,"Midfield"), new Player("Nour Al-Sayed", 1.90f, 80,"Midfield")))));
    static public League league = new League("Egyptian League", 15, 5, Teamlist);
    static public ArrayList<Stadium> Stadiumlist = new ArrayList<>(List.of(
            new Stadium("Cairo International Stadium","Nasr City Cairo", 75000 ),
            new Stadium("Borg El Arab Stadium","Borg El Arab Egypt", 86000 ),
            new Stadium("Cairo Military Academy Stadium","Al-Jaish Cairo", 28500 )
    ));
    static public ArrayList<Referee> Refereelist = new ArrayList<>(List.of(
            new Referee("Moahmed ahmed abdelsala", 1.82f, 70),
            new Referee("Ahmed elsoudi mohamed", 1.75f, 65),
            new Referee("Karim abdelmonai", 1.90f, 80),
            new Referee("Micahel Raze Tollan", 1.72f, 61),
            new Referee("Mostafa mohamed abdelsamd", 1.85f, 70)
    ));
    static public ArrayList<Match> MatchList = getRandomMatches(10);

    static public void deleteObject(Model model) {
        if (model instanceof Team) {
            league.getTeams().removeIf(team -> team.getId().equals(model.getId()));
        }else if (model instanceof Player) {
            for (Team team: league.getTeams()) {
                team.getPlayerList().removeIf(player -> player.getId().equals(model.getId()));
            }
        }else if (model instanceof Match) {
            MatchList.removeIf(match -> match.getId().equals(model.getId()));
        }else if (model instanceof Stadium) {
            Stadiumlist.removeIf(stadium -> stadium.getId().equals(model.getId()));
        }else if (model instanceof Referee) {
            Refereelist.removeIf(referee -> referee.getId().equals(model.getId()));
        }
    }

    static private ArrayList<Match> getRandomMatches(int count) {
        ArrayList<Match> matches = new ArrayList<>();
        if (league.getTeams().size() < 2) {
            return matches;
        }
        for (int i = 0; i < count; i++) {
            ArrayList<Team> tempTeams = new ArrayList<>(league.getTeams());

            Team team1 = tempTeams.get(ThreadLocalRandom.current().nextInt(0, tempTeams.size()-1));
            tempTeams.remove(team1);

            Team team2 = tempTeams.get(ThreadLocalRandom.current().nextInt(0, tempTeams.size()-1));
            ArrayList<Goal> goals = new ArrayList<>();
            int goalsCount = ThreadLocalRandom.current().nextInt(0, 7);
            for(int j = 0; j < goalsCount; j ++) {
                goals.add(new Goal(getRandomPlayer(team1, team2).getId(), getRandomMatchTime()));
            }
            Match match = new Match(team1.getName()+" vs "+team2.getName(),
                    ThreadLocalRandom.current().nextInt(1642007851, 1654104600),
                    Stadiumlist.get(ThreadLocalRandom.current().nextInt(0, Stadiumlist.size()-1)),
                    team1,
                    team2,
                    Refereelist.get(ThreadLocalRandom.current().nextInt(0, Refereelist.size()-1)),
                    goals
                    );

            matches.add(match);
        }
        return matches;
    }
    static public Player getRandomPlayer(Team team1, Team team2){
        ArrayList<Player> players = new ArrayList();
        players.addAll(team1.getPlayerList());
        players.addAll(team2.getPlayerList());
        return players.get(ThreadLocalRandom.current().nextInt(0, players.size() - 1));
    }
    static private String getRandomMatchTime() {
        int minutes = ThreadLocalRandom.current().nextInt(0, 90);
        int seconds = ThreadLocalRandom.current().nextInt(0, 60);
        String minutesStr = Long.toString(minutes);
        if(minutes < 10) {
            minutesStr = '0' + minutesStr;
        }
        String secondsStr = Long.toString(seconds);
        if(seconds < 10) {
            secondsStr = '0' + secondsStr;
        }
        return minutesStr + ':' + secondsStr;
    }
}
