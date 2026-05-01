import me.franck.sportsanalytics.io.DataLoader;
import me.franck.sportsanalytics.logic.League;
import me.franck.sportsanalytics.ui.TextUI;
import me.franck.sportsanalytics.model.Match;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        League league = new League();
        DataLoader dataLoader = new DataLoader("data.csv");
        TextUI userInterface = new TextUI(scanner, league);

        try{
            List<Match> matches = dataLoader.readFile();
            for(Match match: matches){
                league.addMatch(match);
            }
            userInterface.start();
        }catch(Exception e){
            System.out.println("Error: Data couldn't be loaded!");
            e.printStackTrace();
        }
    }
}
