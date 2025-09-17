public class NPC extends Character {

    void action(Character player) {
        int actionNumber = random.nextInt(0, 2);
        switch (actionNumber) {
            case (0) -> {
                if (gun.bulletCount < 1) {
                    System.out.println("\n" + username + " needs to reload");
                    gun.bulletCount = gun.maxBullets;
                } else {
                    int bulletsConsumed = random.nextInt(1, 6);
                    gun.bulletCount = Math.max(0, gun.bulletCount - bulletsConsumed);
                    float hit = random.nextFloat();
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
            } case (1) -> {
                int healAmount = random.nextInt(10, 50);
                hp = Math.min(hp + healAmount, 100);
                System.out.println("\n" + username + " healed " + healAmount + "HP");
            }
        }
    }
}

