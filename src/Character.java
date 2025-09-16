import java.util.Random;

public class Character {
    String username;
    int kills = 0;
    boolean alive = true;
    Weapon gun;
    int hp = 100;
    Random random = new Random();

    void status() {
        System.out.println(username + "\nHP: " + hp + "/100\nKills: " + kills + "\nGun: " + gun.weaponName + "\nAmmo: " + gun.bulletCount + "/" + gun.maxBullets + "\nAlive: " + alive);
    }
}
