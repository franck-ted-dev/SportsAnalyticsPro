package me.franck.sportsanalytics.logic;
import me.franck.sportsanalytics.model.Team;

public class StatisticsEngine {

    public static int numberMatches(Team team){
        return team.statistics.getNumberMatches();
    }

    public static int numberScoaredGoals(Team team){
        return team.statistics.getNumberScoredGoals();
    }

    public static int numberConcecedGoals(Team team){
        return team.statistics.getNumberConcededGoals();
    }

    public static int numberPoints(Team team){
        return 3*team.statistics.getNumberWins()+team.statistics.getNumberDraws();
    }

    public static double winRatio(Team team){
        return team.statistics.getNumberWins()*1.0/team.statistics.getNumberMatches()*100;
    }

    public static int numberDraws(Team team){
        return team.statistics.getNumberDraws();
    }

    public static int numberWins(Team team){
        return team.statistics.getNumberWins();
    }

    public static int numberLoses(Team team){
        return team.statistics.getNumberLoses();
    }

    public static int differenceGoals(Team team){
        return team.statistics.getNumberScoredGoals()- team.statistics.getNumberConcededGoals();
    }
}
