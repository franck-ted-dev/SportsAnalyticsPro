package me.franck.sportsanalytics.model;

public class Stats {
    private int numberMatches;
    private int numberScoredGoals;
    private int numberConcededGoals;
    private int numberWins;
    private int numberLoses;
    private int numberDraws;

    public Stats(){
        this.numberConcededGoals = 0;
        this.numberScoredGoals = 0;
        this.numberMatches = 0;
        this.numberDraws = 0;
        this.numberLoses = 0;
        this.numberWins = 0;
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

    public void addMatch() {
        this.numberMatches++;
    }

    public void setNumberScoredGoals(int number) {
        this.numberScoredGoals += number;
    }

    public void setNumberConcededGoals(int number) {
        this.numberConcededGoals += number;
    }

    public int getNumberWins() {
        return numberWins;
    }

    public void addWin() {
        this.numberWins++;
    }

    public int getNumberLoses() {
        return numberLoses;
    }

    public void addLose() {
        this.numberLoses++;
    }

    public int getNumberDraws() {
        return numberDraws;
    }

    public void addDraw() {
        this.numberDraws++;
    }

    public int numberPoints(){
        return 3*numberWins+numberDraws;
    }

    public double winRatio(){
        return 1.0*numberWins/numberMatches*100;
    }

    public int differenceGoals(){
        return numberScoredGoals - numberConcededGoals;
    }
}
