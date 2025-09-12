public class NPC {
    String NPCname;
    boolean alive = true;
    int kills = 0;
    int hp = 100;
    Weapon gun;

    void action(Player player) {
        if (gun.bulletCount < 1) {
            System.out.println(NPCname + " needs to reload");
        } else {
            float hit = random.nextFloat();
            if (hit < gun.accuracy) {
                player.hp -= gun.damage;
                if (player.hp < 1) {
                    System.out.println("You killed " + player.username);
                    player.alive = false;
                    kills++;
                } else {
                    System.out.println("You dealt " + gun.damage + "damage to " + player.username);
                }
            } else {
                System.out.println("You have missed");
            }
        }
    }

    void action(NPC npc) {
        if (gun.bulletCount < 1) {
            System.out.println(NPCname + " needs to reload");
        } else {
            float hit = random.nextFloat();
            if (hit < gun.accuracy) {
                Player.hp -= gun.damage;
                if (player.hp < 1) {
                    System.out.println("You killed " + npc.NPCname);
                    player.alive = false;
                    kills++;
                } else {
                    System.out.println("You have missed");
                }
            }
        }
    }
}

