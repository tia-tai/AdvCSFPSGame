import java.util.Random;

public class Player {
    String username;
    int kills;
    boolean alive;
    Weapon gun;
    int hp;
    Random random = new Random();

    void shoot(NPC npc) {
        float hit = random.nextFloat();
        if (hit < gun.accuracy) {
            npc.hp -= gun.damage;
            if (npc.hp < 1) {
                System.out.println("You killed " + npc.NPCname);
                npc.alive = false;
                kills++;
            } else {
                System.out.println("You dealt " + gun.damage + " damage to " + npc.NPCname);
            }
        } else {
            System.out.println("You have missed");
        }
    }

    void shoot (Player player) {
        float hit = random.nextFloat();
        if (hit < gun.accuracy) {
            player.hp -= gun.damage;
            if (player.hp < 1) {
                System.out.println("You killed " + player.username);
                player.alive = false;
                kills++;
            } else {
                System.out.println("You dealt " + gun.damage + " damage to " + player.username);
            }
        } else {
            System.out.println("You have missed");
        }
    }

    void heal () {
        int healAmount = random.nextInt(10, 50);
        hp = Math.min(hp + healAmount, 100);
        System.out.println(username + " healed " + healAmount + "HP");
    }

    void status() {
        System.out.println(username + "\n HP: " + hp + "/100\nKills: " + kills + "\nGun: " + gun.weaponName + "\nAlive: " + alive);
    }
}
