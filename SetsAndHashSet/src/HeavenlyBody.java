import java.util.HashSet;
import java.util.Set;

/*
       Modify the previous HeavenlyBody example so that the HeavenlyBody
       class also has a "bodyType" field. This field will store the
       type of HeavenlyBody (such as STAR, PLANET, MOON, etc).

       You can include as many types as you want, but must support at
       least PLANET and MOON.

       For each of the types that you support, subclass the HeavenlyBody class
       so that your program can create objects of the appropriate type.

       Although astronomers may shudder at this, our solar systems will
       allow two bodies to have the same name as long as they are not the
       same type of body: so you could have a star called "BetaMinor" and
       an asteroid also called "BetaMinor", for example.

       Hint: This is much easier to implement for the Set than it is for the Map,
       because the Map will need a key that uses both fields.

       There is a restriction that the only satellites that planets can have must
       be moons. Even if you don't implement a STAR type, though, your program
       should not prevent one being added in the future (and a STAR's satellites
       can be almost every kind of HeavenlyBody).

       Test cases:
       1. The planets and moons that we added in the previous video should appear in
       the solarSystem collection and in the sets of moons for the appropriate planets.

       2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

       3. Attempting to add a duplicate to a Set must result in no change to the set (so
       the original value is not replaced by the new one).

       4. Attempting to add a duplicate to a Map results in the original being replaced
       by the new object.

       5. Two bodies with the same name but different designations can be added to the same set.

       6. Two bodies with the same name but different designations can be added to the same map,
       and can be retrieved from the map.
*/
public abstract class HeavenlyBody{

    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;
    private Key key;

    public enum bodyTypes {
        PLANET,STAR,MOON;
    }

    public HeavenlyBody(String name,double orbitalPeriod,bodyTypes bodytype) {
        this.orbitalPeriod = orbitalPeriod;
        this.key = new Key(name,bodytype);
        this.satelites = new HashSet<>();
    }

    public String getName() {
        return this.getKey().getKeyName();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
//        if(moon.getBodyType()!=bodyTypes.MOON) {
//            System.out.println("Define Proper Type of Planet Object");
//        }
            return this.satelites.add(moon);
    }

    public bodyTypes getBodyType() {
        return this.getKey().getKeyBodyType();
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    @Override
    public final int hashCode() {
//        System.out.println("HashCode Method Called.." + this.name.hashCode());
        return this.key.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj ) {
            return true;
        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody object = (HeavenlyBody) obj;
            return this.getKey().equals(object.getKey());
        }
        return false;

    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name,bodyTypes bodyType) {
        return new Key(name,bodyType);
    }

    @Override
    public String toString() {
        return this.getKey().getKeyName() + " : " + this.getOrbitalPeriod() + " : " + this.getBodyType();
    }

    public static class Key{
        private String keyName;
        private bodyTypes keyBodyType;

        public Key(String keyName, bodyTypes keyBodyType) {
            this.keyName = keyName;
            this.keyBodyType = keyBodyType;
        }

        @Override
        public int hashCode() {
            return this.getKeyName().hashCode() + 57 + this.getKeyBodyType().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key)obj;
            if(this.getKeyName().equals(key.getKeyName())) {
                return this.getKeyBodyType() == key.getKeyBodyType();
            }
            return false;
        }

        public String getKeyName() {
            return keyName;
        }

        public bodyTypes getKeyBodyType() {
            return keyBodyType;
        }
    }
}
