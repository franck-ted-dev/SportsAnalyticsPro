package me.franck.sportsanalytics.ui;
import java.util.Scanner;
import me.franck.sportsanalytics.logic.League;
import me.franck.sportsanalytics.logic.StatisticsEngine;
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
        Team team = this.league.getTeam(teamName);  // Apprete les statistiques de l'equipe

        System.out.println("[RESULTS FOR " + teamName.toUpperCase() + "]");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Matches Played:   " + StatisticsEngine.numberMatches(team));
        System.out.println("Record:           " + StatisticsEngine.numberWins(team) + " Wins, " + StatisticsEngine.numberDraws(team) + " Draws, " + StatisticsEngine.numberLoses(team) + " Losses");
        System.out.println("Points:           " + StatisticsEngine.numberPoints(team));
        System.out.println("Win Ratio:        " + StatisticsEngine.winRatio(team) + "%");
        System.out.println("Goals:            " + StatisticsEngine.numberScoaredGoals(team) + " scored, " + StatisticsEngine.numberConcecedGoals(team) + " conceded");
        System.out.println("-----------------------------------------------------------------");
        return;
    }

    // affiche le classement de la ligue
    private void currentStanding(){

        System.out.println();
        System.out.println("[CURRENT STANDINGS]");
        System.out.println("Rank  | Team           | Points | Games |  W  |  D  |  L  |  GS  |  GC  |  GD ");
        int pos = 1;
        for(Team team : league.ranking()){
            System.out.printf("%-5s | %-14s | %-6s | %-5s | %-3s | %-3s | %-3s | %-4s | %-4s | %-4s%n",
                    pos+".",
                    team.getName(),
                    StatisticsEngine.numberPoints(team),
                    StatisticsEngine.numberMatches(team),
                    StatisticsEngine.numberWins(team),
                    StatisticsEngine.numberDraws(team),
                    StatisticsEngine.numberLoses(team),
                    StatisticsEngine.numberScoaredGoals(team),
                    StatisticsEngine.numberConcecedGoals(team),
                    StatisticsEngine.differenceGoals(team));
            pos++;
        }
    }

    private void statistics(){

    }
}
