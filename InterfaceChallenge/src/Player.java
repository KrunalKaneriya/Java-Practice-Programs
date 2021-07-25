import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String playerName;
    private int health;
    private String weapon;

    public Player(String playerName, int health, String weapon) {
        this.playerName = playerName;
        this.health = health;
        this.weapon = weapon;
    }

    @Override
    public void readValues(List<String> savedValues) {
        if(savedValues!=null && savedValues.size()>0) {
            this.playerName = savedValues.get(0);
            this.health = Integer.parseInt(savedValues.get(1));
            this.weapon = savedValues.get(2);
        }
    }

    @Override
    public String toString() {
        return "Player { " +
                "Name : " + this.playerName +
                " Health : " + this.getHealth() +
                " Weapon : " + this.getWeapon() +
                " }";
    }

    @Override
    public List<String> writeValues() {
        List<String>values = new ArrayList<>();
        values.add(0,this.playerName);
        values.add(1,"" + this.health);
        values.add(2,this.weapon);
        return values;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
