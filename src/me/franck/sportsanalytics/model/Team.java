package me.franck.sportsanalytics.model;

public class Team {
    private Stats statistics;
    private String name;

    public Team(String name){
        this.name = name;
        this.statistics = new Stats();
    }

    public void addMatch(){
        this.statistics.addMatch();
    }

    public void setNumberConcededGoals(int number){
        this.statistics.setNumberConcededGoals(number);
    }

    public void setNumberScoredGoals(int number){
        this.statistics.setNumberScoredGoals(number);
    }

    public void addWin(){
        this.statistics.addWin();
    }

    public void addDraw(){
        this.statistics.addDraw();
    }

    public void addLose(){
        this.statistics.addLose();
    }

    public String getName(){
        return this.name;
    }

    public Stats getStatistics(){
        return this.statistics;
    }
}
