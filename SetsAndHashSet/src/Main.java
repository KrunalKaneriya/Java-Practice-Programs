import java.util.*;

public class Main {
    private static Map<HeavenlyBody.Key,HeavenlyBody>solarSystem = new HashMap<>();
    private static Set<HeavenlyBody>planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);


        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        Planet pluto = new Planet("Pluto",250);
        solarSystem.put(pluto.getKey(), pluto);


        Set<HeavenlyBody>moons = new HashSet<>();

//        Planet neptune = new Planet("Neptune",100);
//        solarSystem.put(neptune.getName(),neptune);
//        planets.add(neptune);
//
//        Moon pluto = new Moon("Pluto",250);
//        solarSystem.put(pluto.getName(),pluto);
//        planets.add(pluto);

//        System.out.println(pluto.equals(neptune));
        System.out.println("Solar System");

        for(HeavenlyBody planet:solarSystem.values()) {
            System.out.println("The Name of Planet is " + planet.getKey().getKeyName());
            System.out.println("The Orbital Period is " + planet.getOrbitalPeriod());
            System.out.println("*************************************");
        }

//        Planet earth1 = new Planet("Earth",369);
//        Planet earth2 = new Planet("Earth",368);
//        System.out.println(earth1.equals(earth2));
//        System.out.println(earth2.equals(earth1));

//        for (HeavenlyBody planet:planets) {
//            System.out.println("\t" + planet.getName() + " \tOrbital Period: " + planet.getOrbitalPeriod());
//            moons.addAll(planet.getSatelites());
//            for(HeavenlyBody moon:planet.getSatelites()) {
//                System.out.println("\t\t" + moon.getName() + " Orbital Period " + moon.getOrbitalPeriod());
//            }
//        }
//
//        System.out.println("\n\nAll Moons");
//        for(HeavenlyBody moon:moons) {
//            System.out.println("\t" + moon.getName());
//        }
    }
}
