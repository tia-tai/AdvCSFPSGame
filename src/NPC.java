public class NPC {
    String NPCname;
    boolean alive;
    int kills;
    int hp;
    Weapon gun;

    void action(Player player) {
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
