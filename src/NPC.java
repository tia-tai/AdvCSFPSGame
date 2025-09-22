public class NPC extends Character { // Sam

    public NPC(String username, int kills, boolean alive, Weapon gun, int hp) {
        super(username, kills, alive, gun, hp);
    }

    public NPC() { super();
    }

    void action(Character player) {
        int actionNumber = random.nextInt(0, 2);
        switch (actionNumber) {
            case (0) -> {
                if (this.getGun().bulletCount < 1) {
                    System.out.println("\n" + this.getUsername() + " needs to reload");
                    this.getGun().bulletCount = this.getGun().maxBullets;
                } else {
                    int bulletsConsumed = random.nextInt(1, 6);
                    this.getGun().bulletCount = Math.max(0, this.getGun().bulletCount - bulletsConsumed);
                    float hit = random.nextFloat();
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
            } case (1) -> {
                int healAmount = random.nextInt(10, 50);
                this.setHp(Math.min(this.getHp() + healAmount, 100));
                System.out.println("\n" + this.getUsername() + " healed " + healAmount + "HP");
            }
        }
    }
    public String toString() {
        String niceString = "NPC ";
        niceString += this.getUsername();
        return niceString;
    }
}

