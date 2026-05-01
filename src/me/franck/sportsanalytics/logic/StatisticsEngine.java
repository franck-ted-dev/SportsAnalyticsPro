package me.franck.sportsanalytics.logic;
import me.franck.sportsanalytics.model.Team;

public class StatisticsEngine {
    private Team team;

    public StatisticsEngine(Team team){
        this.team = team;
    }

    public int numberMatches(){
        return this.team.getNumberMatches();
    }

    public int numberScoaredGoals(){
        return this.team.getNumberScoredGoals();
    }

    public int numberConcecedGoals(){
        return this.team.getNumberConcededGoals();
    }

    public int numberPoints(){
        return 3*team.getNumberWins()+team.getNumberDraws();
    }

    public double winRatio(){
        return team.getNumberWins()*1.0/team.getNumberMatches()*100;
    }

    public int numberDraws(){
        return team.getNumberDraws();
    }

    public int numberWins(){
        return team.getNumberWins();
    }

    public int numberLoses(){
        return team.getNumberLoses();
    }
}
