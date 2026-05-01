package me.franck.sportsanalytics.logic;
import me.franck.sportsanalytics.model.Team;

public class StatisticsEngine {

    public static int numberMatches(Team team){
        if(team == null){ // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberMatches();
    }

    public static int numberScoaredGoals(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberScoredGoals();
    }

    public static int numberConcecedGoals(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberConcededGoals();
    }

    public static int numberPoints(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return 3*team.getStatistics().getNumberWins()+team.getStatistics().getNumberDraws();
    }

    public static double winRatio(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberWins()*1.0/team.getStatistics().getNumberMatches()*100;
    }

    public static int numberDraws(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberDraws();
    }

    public static int numberWins(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberWins();
    }

    public static int numberLoses(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberLoses();
    }

    public static int differenceGoals(Team team){
        if(team == null){  // n'est pas cense arrive, mais bon!!!
            return 0;
        }
        return team.getStatistics().getNumberScoredGoals()- team.getStatistics().getNumberConcededGoals();
    }
}
