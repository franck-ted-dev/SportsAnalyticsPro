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

    // ajouter une equipe dans la league
    public void addTeam(String name){
        this.teams.putIfAbsent(name, new Team(name));
    }

    // update les statistiques d'une equipe
    public void update(String name, int concededGoals){

    }

    // ajouter un match
    public void addMatch(Match matchToAdd){
        this.matches.add(matchToAdd);
    }
}
