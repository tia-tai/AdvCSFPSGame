import java.util.Random;

public class NPC extends Character {

    void action(Character player) {
        if (gun.bulletCount < 1) {
            System.out.println(username + " needs to reload");
            gun.bulletCount = gun.maxBullets;
        } else {
            int bulletsConsumed = random.nextInt(1, 6);
            gun.bulletCount = Math.max(0, gun.bulletCount - bulletsConsumed);
            //float hit = Random.nextFloat();
            float hit = 0.5f;
            if (hit < gun.accuracy) {
                player.hp -= gun.damage;
                if (player.hp < 1) {
                    System.out.println(username + " killed " + player.username);
                    player.alive = false;
                    kills++;
                } else {
                    System.out.println(username + " dealt " + gun.damage + " damage to " + player.username);
                }
            } else {
                System.out.println(username + " have missed");
            }
        }
    }

    void action(NPC npc) {
        if (gun.bulletCount < 1) {
            System.out.println(username + " needs to reload");
            gun.bulletCount = gun.maxBullets;
        } else {
            int bulletsConsumed = random.nextInt(1, 6);
            gun.bulletCount = Math.max(0, gun.bulletCount - bulletsConsumed);
            //float hit = Random.nextFloat();
            float hit = 0.5f;
            if (hit < gun.accuracy) {
                npc.hp -= gun.damage;
                if (npc.hp < 1) {
                    System.out.println(username + " killed " + npc.username);
                    npc.alive = false;
                    kills++;
                } else {
                    System.out.println(username + " have missed");
                }
            }
        }
    }
}

