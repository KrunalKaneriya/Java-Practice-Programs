package com.krunalkaneria.leaguemanagement;

public class Main {

    public static void main(String[] args) {

        //com.krunalkaneria.leaguemanagement.Football adelaideCrows com.krunalkaneria.leaguemanagement.Team
        Team<Football> adelaideCrows= new Team<>("Adelaide Crows");
        Football joe = new Football("Joe");
        adelaideCrows.addPlayer(joe);


        //com.krunalkaneria.leaguemanagement.Football Chicago Cubs com.krunalkaneria.leaguemanagement.Team
        Team<Baseball>chicagoCubs = new Team<>("Chicago Cubs");
        Baseball patrick = new Baseball("Patrick");
        chicagoCubs.addPlayer(patrick);

        //com.krunalkaneria.leaguemanagement.Cricket India com.krunalkaneria.leaguemanagement.Team
        Team<Cricket>india = new Team<>("India");
        Cricket kohli = new Cricket("Kohli");
        Cricket dhoni = new Cricket("Dhoni");
        Cricket krunal = new Cricket("Krunal Pandya");
        india.addPlayer(kohli);
        india.addPlayer(dhoni);
        india.addPlayer(krunal);


        //com.krunalkaneria.leaguemanagement.Cricket West Indies com.krunalkaneria.leaguemanagement.Team
        Team<Cricket>westIndies = new Team<>("West Indies");
        Cricket gayle = new Cricket("Chris Gayle");
        Cricket dwayne = new Cricket("Dwayne Bravo");
        westIndies.addPlayer(dwayne);
        westIndies.addPlayer(gayle);

        //Pakistan com.krunalkaneria.leaguemanagement.Team
        Team<Cricket>pakistan = new Team<>("Pakistan");
        Cricket afridi= new Cricket("Shahid Afridi");
        Cricket imran = new Cricket("Imran Khan");
        Cricket mohammad = new Cricket("Mohammad Ismail");
        pakistan.addPlayer(mohammad);
        pakistan.addPlayer(imran);
        pakistan.addPlayer(afridi);


        System.out.println(india.playersSize());

        india.matchResult(westIndies,50,90);
        india.matchResult(pakistan,10,5);
        westIndies.matchResult(pakistan,50,60);
        pakistan.matchResult(westIndies,10,50);
        pakistan.matchResult(india,20,50);

        System.out.println("=============Ranking=================");
//        System.out.println("The Rank of com.krunalkaneria.leaguemanagement.Team India is " + india.ranking());
//        System.out.println("The Rank of com.krunalkaneria.leaguemanagement.Team West Indies is " + westIndies.ranking());
//        System.out.println("The Rank of com.krunalkaneria.leaguemanagement.Team Pakistan is " + pakistan.ranking());

        League<Team<Cricket>> worldCricketLeague = new League<>("World com.krunalkaneria.leaguemanagement.Cricket com.krunalkaneria.leaguemanagement.League");
        worldCricketLeague.addTeam(india);
        worldCricketLeague.addTeam(westIndies);
        worldCricketLeague.addTeam(pakistan);
        worldCricketLeague.showLeagueTable();



    }
}
