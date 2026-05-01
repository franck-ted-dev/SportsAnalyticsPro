import me.franck.sportsanalytics.io.DataLoader;
import me.franck.sportsanalytics.logic.League;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        League league = new League();
        DataLoader dataLoader = new DataLoader("data.csv", league);
    }
}
