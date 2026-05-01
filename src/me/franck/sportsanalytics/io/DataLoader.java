package me.franck.sportsanalytics.io;
import me.franck.sportsanalytics.logic.League;
import me.franck.sportsanalytics.model.Match;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class DataLoader {
    private String filename;    // on lira les infos de ce fichier
    private League league;      // on enregistrera les infos dans cet objet

    public DataLoader(String filename, League league) throws IOException {
        this.filename = filename;
        this.league = league;
    }

    // lis le fichier lignes par lignes
    public void readFile(){
        try(Scanner scanner = new Scanner(Paths.get(this.filename))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();  // on lit une ligne
                String[] tab = line.split(",");  // on la decoupe
                String homeTeam = tab[0];
                String awayTeam = tab[1];
                // un match c'est entre 2 equipes differentes.
                if(homeTeam.equals(awayTeam)){
                    continue;   // pas un match valide.
                }
                int homeScore = Integer.parseInt(tab[2]);
                int awayScore = Integer.parseInt(tab[3]);
                if(homeScore < 0 || awayScore < 0){
                    continue;   // un score negatif ? Impossible
                }
                // ajoute le match a la ligue
                // chaque ligne correcte correspond a un match.
                this.league.addMatch(new Match(homeTeam, awayTeam, homeScore, awayScore));
            }
            System.out.println("Data loaded succesfully!");
        }catch(Exception e){
            System.out.println("Error: Data couldn't be loaded!");
            e.printStackTrace();
        }
    }
}
