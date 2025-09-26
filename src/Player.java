import java.util.Random;

public class Player extends Character { // Tai

    public Player(String username, int kills, boolean alive, Weapon gun, int hp) {
        super(username, kills, alive, gun, hp);
    }

    public Player() {
        super();
    }

    void shoot(Character player) {
        if (this.getGun().bulletCount < 1) {
            System.out.println("\n" + this.getUsername() + " needs to reload");
        }
        else {
            float hit = random.nextFloat();
            int bulletsConsumed = random.nextInt(1, 6);
            this.getGun().bulletCount = Math.max(0, this.getGun().bulletCount - bulletsConsumed);
            if (hit < this.getGun().accuracy) {
                player.setHp(player.getHp() - this.getGun().damage);
                if (player.getHp() < 1) {
                    System.out.println("\n" + this.getUsername() + " killed " + player.getUsername());
                    player.setAlive(false);
                    this.setKills(this.getKills() + 1);
                } else {
                    System.out.println("\n" + this.getUsername() + " dealt " + this.getGun().damage + " damage to " + player.getUsername());
                }
            } else {
                System.out.println("\n" + this.getUsername() + " have missed");
            }
        }
    }

    void reload () {
        this.getGun().bulletCount = this.getGun().maxBullets;
        System.out.println("\n" + this.getUsername() + " has reloaded their gun");
    }

    void heal () {
        int healAmount = random.nextInt(10, 50);
        this.setHp(Math.min(this.getHp() + healAmount, 100));
        System.out.println("\n" + this.getUsername() + " healed " + healAmount + "HP");
    }

    public String toString() {
        return "\nHP: " + this.getHp() + "/100";
    }

    void status() {
        System.out.println(username + "\n HP: " + hp + "/100\nKills: " + kills + "\nGun: " + gun.weaponName + "\nAmmo: " + gun.bulletCount + "/" + gun.maxBullets + "\nAlive: " + alive);
    }
}
