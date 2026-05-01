package me.franck.sportsanalytics.ui;
import java.util.Scanner;
import me.franck.sportsanalytics.logic.League;

public class TextUI {
    private Scanner scanner;
    private League league;

    public TextUI(Scanner scanner, League league){
        this.scanner = scanner;
        this.league = league;
    }

    public void start(){
        System.out.println("Available commands:");
        System.out.println("  [1] Team Search");
        System.out.println("  [2] Current Standing");
        System.out.println("  [3] Statistics");
        System.out.println("  [4] Exit");

        while(true){
            System.out.println();
            System.out.print("Selection: ");
            int selection = Integer.valueOf(scanner.nextLine());

            switch (selection){
                case 1:
                    this.teamSearch();
                    break;
                case 2:
                    this.currentStanding();
                    break;
                case 3:
                    this.statistics();
                    break;
                case 4:
                    return;
            }
        }
    }

    // interface pour informations sur une equipe
    private void teamSearch(){
        System.out.println();
        System.out.print("Enter team name: ");  // recupere le nom de l'equipe
        String teamName = scanner.nextLine();

        System.out.println();

        if(!league.isTeam(teamName)){    // est-ce une equipe de la league ?
            System.out.println("This is not a team of our league!");
            return;
        }

        // envoie le nom de l'equipe a la ligue
        // et la ligue prepare toutes les statistiques de l'equipe
        this.league.statistics(teamName);   // Apprete les statistiques de l'equipe

        teamName = teamName.toUpperCase();

        System.out.println("[RESULTS FOR " + teamName + "]");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Matches Played:   ");
        System.out.println("Record:           ");
        System.out.println("Points:           ");
        System.out.println("Win Ratio:        ");
        System.out.println("Goals:            ");
        System.out.println("-----------------------------------------------------------------");
        return;
    }

    private void currentStanding(){

    }

    private void statistics(){

    }
}
