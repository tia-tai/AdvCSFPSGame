import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();

        Player kim = new Player();
        kim.username = "Kim";

        Weapon vandal = new Weapon();
        vandal.weaponName = "Vandal";
        vandal.maxBullets = 25;
        vandal.bulletCount = 25;
        vandal.damage = 45;
        vandal.accuracy = 0.6;

        kim.gun = vandal;

        players.add(kim);
        // create an Object of type Weapon
        Weapon harry = new Weapon();
        harry.weaponname = "MP5";
        harry.shooting = true;
        harry.reloading = true;
        harry.maxBullets = true;
        harry.bulletCount = false;
        harry.damage = true;


    }
}