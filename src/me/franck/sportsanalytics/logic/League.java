package me.franck.sportsanalytics.logic;
import me.franck.sportsanalytics.model.Stats;
import me.franck.sportsanalytics.model.Team;
import me.franck.sportsanalytics.model.Match;

import java.util.*;

public class League {
    private final Map<String, Team> teams;
    private final List<Match> matches;

    public League(){
        this.matches = new ArrayList<>();
        this.teams = new HashMap<>();
    }

    // ajouter une équipe dans la league
    public void addTeam(String name){
        this.teams.put(name, new Team(name));
    }

    // update les statistiques d'une équipe
    public void update(Match match){
        String homeTeam = match.getHomeTeam();
        String awayTeam = match.getAwayTeam();
        int homeScore = match.getHomeScore();
        int awayScore = match.getAwayScore();
        // cree l'equipe a domicile si necessaire
        if(!this.isTeam(homeTeam)){
           this.addTeam(homeTeam);
        }
        // ajuste ses statistiques
        this.teams.get(homeTeam).addMatch();
        this.teams.get(homeTeam).setNumberConcededGoals(awayScore);
        this.teams.get(homeTeam).setNumberScoredGoals(homeScore);

        // pareil avec l'equipe a l'exterieur
        if(!this.isTeam(awayTeam)){
            this.addTeam(awayTeam);
        }
        this.teams.get(awayTeam).addMatch();
        this.teams.get(awayTeam).setNumberConcededGoals(homeScore);
        this.teams.get(awayTeam).setNumberScoredGoals(awayScore);

        // s'il s'agit d'un match nul
        if(match.isDraw()){
            this.teams.get(homeTeam).addDraw();
            this.teams.get(awayTeam).addDraw();
            return;
        }

        if(awayTeam.equals(match.getWinner())){
            this.teams.get(awayTeam).addWin();
            this.teams.get(homeTeam).addLose();
        }else{
            this.teams.get(homeTeam).addWin();
            this.teams.get(awayTeam).addLose();
        }
    }

    // verifie si name est une equipe de la ligue
    public boolean isTeam(String name){
        return this.teams.containsKey(name);
    }

    // la ligue recoit le nom de l'equipe
    // et fait preparer ses statistiques,
    // elle crée une instance de StatisticsEngine specialement
    // pour cette equipe

    // ajouter un match
    public void addMatch(Match matchToAdd){
        // ajoute d'abord un match
        this.matches.add(matchToAdd);
        // ajuste ensuite les statistiques de chaque equipe du match
        this.update(matchToAdd);
    }

    public Stats teamStats(String teamName){
        return this.teams.get(teamName).getStatistics();
    }

    public Team getTeam(String teamName){
        return this.teams.get(teamName);
    }

    public ArrayList<Team> ranking(){
        ArrayList<Team> listTeam = new ArrayList<>(this.teams.values());
        Comparator<Team> byPointsAndByGoals = Comparator
                .comparing(StatisticsEngine::numberPoints, Comparator.reverseOrder())
                .thenComparing(StatisticsEngine::differenceGoals, Comparator.reverseOrder())
                .thenComparing(StatisticsEngine::numberScoaredGoals, Comparator.reverseOrder());
        listTeam.sort(byPointsAndByGoals);
        return listTeam;
    }
}
