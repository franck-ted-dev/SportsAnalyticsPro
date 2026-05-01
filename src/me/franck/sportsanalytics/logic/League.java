package me.franck.sportsanalytics.logic;
import me.franck.sportsanalytics.model.Team;
import me.franck.sportsanalytics.model.Match;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class League {
    private Map<String, Team> teams;
    private List<Match> matches;

    public League(){
        this.matches = new ArrayList<>();
        this.teams = new HashMap<>();
    }

    // ajouter une équipe dans la league
    public void addTeam(String name){
        this.teams.put(name, new Team(name));
    }

    // update les statistiques d'une équipe
    public void update(String nameTeam, int scoaredGoals, int concededGoals){
        // cree l'equipe si necessaire
        if(!this.isTeam(nameTeam)){
           this.addTeam(nameTeam);
        }
        // ajuste ses statistiques
        this.teams.get(nameTeam).setNumberMatches(1);
        this.teams.get(nameTeam).setNumberConcededGoals(concededGoals);
        this.teams.get(nameTeam).setNumberScoredGoals(scoaredGoals);
    }

    // verifie si name est une equipe de la ligue
    public boolean isTeam(String name){
        return this.teams.containsKey(name);
    }

    // ajouter un match
    public void addMatch(Match matchToAdd){
        // ajoute d'abord un match
        this.matches.add(matchToAdd);
        // ajuste ensuite les statistiques de chaque equipe du match
        this.update(matchToAdd.getHomeTeam(), matchToAdd.getHomeScore(), matchToAdd.getAwayScore());
        this.update(matchToAdd.getAwayTeam(), matchToAdd.getAwayScore(), matchToAdd.getHomeScore());
    }
}
