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
        System.out.printf("Win Ratio:        %.2f%%\n",StatisticsEngine.winRatio(team));
        System.out.println("Goals:            " + StatisticsEngine.numberScoaredGoals(team) + " scored, " + StatisticsEngine.numberConcecedGoals(team) + " conceded");
        System.out.println("-----------------------------------------------------------------");
        return;
    }

    // affiche le classement de la ligue
    private void currentStanding(){

        System.out.println();
        System.out.println("[CURRENT STANDINGS]");
        System.out.println("Rank  | Team               | Points | Games |  W  |  D  |  L  |  GS  |  GC  |  GD ");
        int pos = 1;
        for(Team team : league.ranking()){
            System.out.printf("%-5s | %-18s | %-6s | %-5s | %-3s | %-3s | %-3s | %-4s | %-4s | %-4s%n",
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
        System.out.println();
        if(league.isEmpty()){
            System.out.println("The league is empty!");
            System.out.println("No statistics available!");
            return;
        }
        System.out.println("TEAM RECORDS");
        Team team = league.getBestAttack();
        System.out.println("The best attack: " + team.getName() + " (" + StatisticsEngine.numberScoaredGoals(team) +" goals)");

        team = league.getBestDefense();
        System.out.println("The best defense: " + team.getName() + " (" + StatisticsEngine.numberConcecedGoals(team) +" goals)");

        team = league.getBestGD();
        System.out.println("Top goal difference team: " + team.getName() + " (" + StatisticsEngine.differenceGoals(team) +" goals)");

        team = league.bestShowTeam();
        System.out.printf("Top show producer: " + team.getName() + " (%.2f goals/match)\n",StatisticsEngine.showIndex(team));

        team = league.bestWinRatio();
        System.out.printf("Top Win Ratio:" + team.getName() + " (%.2f%%)\n",StatisticsEngine.winRatio(team));
    }
}
