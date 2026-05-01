package me.franck.sportsanalytics.model;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getWinner(){
        if(awayScore > homeScore){
            return awayTeam;
        }else if(homeScore > awayScore){
            return homeTeam;
        }else{
            return null;
        }
    }

    public String getLooser(){
        if(awayScore < homeScore){
            return awayTeam;
        }else if(homeScore < awayScore){
            return homeTeam;
        }else{
            return null;
        }
    }

    public boolean isDraw(){
        return awayScore == homeScore;
    }
}
