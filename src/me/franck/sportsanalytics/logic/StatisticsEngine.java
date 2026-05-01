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
        return this.team.getNumberScoredGoals()
    }

    public int numberConcecedGoals(){
        return this.team.getNumberConcededGoals();
    }

    public int numberPoints(){
        return 0;
    }
}
