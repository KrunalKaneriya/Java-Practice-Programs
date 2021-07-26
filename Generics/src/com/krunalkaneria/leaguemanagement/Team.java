package com.krunalkaneria.leaguemanagement;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private final String teamName;
    private int wonCount;
    private int lostCount;
    private int tiedCount;
    private int matchesPlayed;

    ArrayList<Player>members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean addPlayer(T player) {
        if(members.contains(player)) {
            System.out.println("com.krunalkaneria.leaguemanagement.Player is already Added in com.krunalkaneria.leaguemanagement.Team " + this.teamName);
            return false;
        }
        else {
            members.add(player);
            System.out.println("com.krunalkaneria.leaguemanagement.Player " + player.getPlayerName() + " picked for com.krunalkaneria.leaguemanagement.Team " + this.teamName);
            return true;

        }
    }

    public int playersSize() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent,int ourScore,int theirScore) {
        String message = null;
        if(ourScore > theirScore) {
            wonCount++;
            message = " beats ";
        }
        else if(theirScore > ourScore) {
            lostCount++;
            message = " lost to ";
        }
        else if(ourScore == theirScore) {
            tiedCount++;
            message = " drew with ";
        }

        if(opponent!=null) {
            System.out.println(this.getTeamName() + message + opponent.getTeamName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking() {
        return (wonCount*2)+tiedCount;
    }

    @Override
    public int compareTo(Team<T> object) {
        if(this.ranking() > object.ranking()) {
            return -1;
        } else if(this.ranking() < object.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
