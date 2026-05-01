import me.franck.sportsanalytics.io.DataLoader;
import me.franck.sportsanalytics.logic.League;
import me.franck.sportsanalytics.ui.TextUI;
import java.util.Scanner;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        Scanner scanner = new Scanner(System.in);
        League league = new League();
        DataLoader dataLoader = new DataLoader("data.csv", league);
        TextUI userInterface = new TextUI(scanner, league);

        dataLoader.readFile();
        userInterface.start();
    }
}
