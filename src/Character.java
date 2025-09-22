import java.util.Random;

public class Character {
    private String username;
    private int kills;
    private boolean alive = true;
    private Weapon gun;
    private int hp;
    Random random = new Random();

    public Character(String username, int kills, boolean alive, Weapon gun, int hp) {
        this.username = username;
        this.kills = kills;
        this.alive = alive;
        this.gun = gun;
        this.hp = hp;
    }

    public Character() {

    }

    void status() {
        System.out.println("\n" + username + "\nHP: " + hp + "/100\nKills: " + kills + "\nGun: " + gun.weaponName + "\nAmmo: " + gun.bulletCount + "/" + gun.maxBullets + "\nAlive: " + alive);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Weapon getGun() {
        return gun;
    }

    public void setGun(Weapon gun) {
        this.gun = gun;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
