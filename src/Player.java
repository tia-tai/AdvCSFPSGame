import java.util.Random;

public class Player extends Character {

    void shoot(Character player) {
        if (gun.bulletCount < 1) {
            System.out.println("\n" + username + " needs to reload");
        }
        else {
            float hit = random.nextFloat();
            int bulletsConsumed = random.nextInt(1, 6);
            gun.bulletCount = Math.max(0, gun.bulletCount - bulletsConsumed);
            if (hit < gun.accuracy) {
                player.hp -= gun.damage;
                if (player.hp < 1) {
                    System.out.println("\n" + username + " killed " + player.username);
                    player.alive = false;
                    kills++;
                } else {
                    System.out.println("\n" + username + " dealt " + gun.damage + " damage to " + player.username);
                }
            } else {
                System.out.println("\n" + username + " have missed");
            }
        }
    }

    void reload () {
        gun.bulletCount = gun.maxBullets;
        System.out.println("\n" + username + " has reloaded their gun");
    }

    void heal () {
        int healAmount = random.nextInt(10, 50);
        hp = Math.min(hp + healAmount, 100);
        System.out.println("\n" + username + " healed " + healAmount + "HP");
    }

}
