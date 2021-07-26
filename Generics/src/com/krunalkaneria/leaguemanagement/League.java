package com.krunalkaneria.leaguemanagement;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team>{
    public String leagueName;

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public ArrayList<T>teamsArrayList = new ArrayList<>();
    public boolean addTeam(T team) {
        if(teamsArrayList.contains(team)) {
            System.out.println("com.krunalkaneria.leaguemanagement.Team is already added in league..");
            return false;
        }
        else {
            teamsArrayList.add(team);
            System.out.println("com.krunalkaneria.leaguemanagement.Team " + team.getTeamName() + " is added to com.krunalkaneria.leaguemanagement.League " + leagueName);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(teamsArrayList);
        for(T t : teamsArrayList) {
            System.out.println(t.getTeamName() + " : " + t.ranking());
        }
    }
}
