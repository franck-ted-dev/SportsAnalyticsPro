package me.franck.sportsanalytics.ui;
import java.util.Scanner;
import me.franck.sportsanalytics.logic.League;
import me.franck.sportsanalytics.model.Stats;
import me.franck.sportsanalytics.model.Team;

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
        Stats statTeam = this.league.teamStats(teamName);  // Apprete les statistiques de l'equipe

        System.out.println("[RESULTS FOR " + teamName.toUpperCase() + "]");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Matches Played:   " + statTeam.getNumberMatches());
        System.out.println("Record:           " + statTeam.getNumberWins() + " Wins, " + statTeam.getNumberDraws() + " Draws, " + statTeam.getNumberLoses() + " Losses");
        System.out.println("Points:           " + statTeam.numberPoints());
        System.out.println("Win Ratio:        " + statTeam.winRatio() + "%");
        System.out.println("Goals:            " + statTeam.getNumberScoredGoals() + " scored, " + statTeam.getNumberConcededGoals() + " conceded");
        System.out.println("-----------------------------------------------------------------");
        return;
    }

    private void currentStanding(){

        System.out.println();
        System.out.println("[CURRENT STANDINGS]");
        System.out.println("Rank  | Team           | Points | Games |  W  |  D  |  L  |  GS  |  GC  |  GD ");
        int pos = 1;
        for(Team team : league.ranking()){
            System.out.printf("%-5s | %-14s | %-6s | %-5s | %-3s | %-3s | %-3s | %-4s | %-4s | %-4s%n",
                    pos+".",
                    team.name,
                    team.statistics.numberPoints(),
                    team.statistics.getNumberMatches(),
                    team.statistics.getNumberWins(),
                    team.statistics.getNumberDraws(),
                    team.statistics.getNumberLoses(),
                    team.statistics.getNumberScoredGoals(),
                    team.statistics.getNumberConcededGoals(),
                    team.statistics.differenceGoals());
            pos++;
        }
    }

    private void statistics(){

    }
}
