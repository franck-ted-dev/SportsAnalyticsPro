package me.franck.sportsanalytics.model;

public class Team {
    private int numberMatches;
    private String name;
    private int numberScoredGoals;
    private int numberConcededGoals;

    public Team(String name){
        this.name = name;
        this.numberConcededGoals = 0;
        this.numberScoredGoals = 0;
        this.numberMatches = 0;
    }

    public int getNumberMatches() {
        return numberMatches;
    }

    public int getNumberScoredGoals() {
        return numberScoredGoals;
    }

    public int getNumberConcededGoals() {
        return numberConcededGoals;
    }

    public void setNumberMatches(int number) {
        this.numberMatches += number;
    }

    public void setNumberScoredGoals(int number) {
        this.numberScoredGoals += number;
    }

    public void setNumberConcededGoals(int number) {
        this.numberConcededGoals += number;
    }
}
