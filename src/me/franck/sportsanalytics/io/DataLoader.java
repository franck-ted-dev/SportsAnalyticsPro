package me.franck.sportsanalytics.io;
import java.util.List;
import java.util.ArrayList;
import me.franck.sportsanalytics.model.Match;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class DataLoader {
    private String filename;    // on lira les infos de ce fichier

    public DataLoader(String filename) {
        this.filename = filename;
    }

    // lis le fichier lignes par lignes
    public List<Match> readFile() throws IOException{
        Scanner scanner = new Scanner(Paths.get(this.filename));
        List<Match> matches = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            try{
                // on lit une ligne
                if(line.isBlank()){
                    continue;  // on ignore les lignes vides
                }
                String[] tab = line.split(",");  // on la decoupe
                if(tab.length < 4){
                    continue;  // les lignes incompletes sont ignorees.
                }
                String homeTeam = tab[0].trim();
                String awayTeam = tab[1].trim();
                // un match c'est entre 2 equipes differentes.
                if(homeTeam.equals(awayTeam)){
                    continue;   // pas un match valide.
                }
                int homeScore = Integer.parseInt(tab[2].trim());
                int awayScore = Integer.parseInt(tab[3].trim());
                if(homeScore < 0 || awayScore < 0){
                    continue;   // un score negatif ? Impossible
                }
                // ajoute le match a la ligue
                // chaque ligne correcte correspond a un match.
                matches.add(new Match(homeTeam, awayTeam, homeScore, awayScore));
            }catch(Exception e){
                String errorMsg = "Erreur ligne : " + line + " | Raison : " + e.getMessage();

                System.err.println(errorMsg);

                try {
                    Files.write(
                            Paths.get("errors.log"),
                            (errorMsg + System.lineSeparator()).getBytes(),
                            StandardOpenOption.CREATE, // Crée le fichier s'il n'existe pas
                            StandardOpenOption.APPEND // Ajoute à la fin sans écraser
                    );
                } catch (IOException ioException) {
                    System.err.println("Impossible d'écrire dans le fichier de log !");
                }
            }

        }
        System.out.println("Data loaded succesfully!");
        return matches;
    }
}
