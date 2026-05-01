package me.franck.sportsanalytics.io;
import me.franck.sportsanalytics.logic.League;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

public class DataLoader {
    private String filename;
    private League league;

    public DataLoader(String filename, League league) throws IOException {
        this.filename = filename;
        this.league = league;
    }

    // lis le fichier ligne par ligne
    public void readFile(){
        try(Scanner scanner = new Scanner(Paths.get(this.filename))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] tab = line.split(",");
                this.league.addTeam(tab[0]);
                this.league.addTeam(tab[1]);
            }
        }catch(Exception e){
            System.out.println("Error: Data couldn't be loaded!");
        }
    }
}
