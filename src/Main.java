import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        ArrayList<Character> allCharacters = new ArrayList<Character>();
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Player kim = new Player();
        kim.username = "Kim";

        Weapon vandal = new Weapon();
        vandal.weaponName = "Vandal";
        vandal.maxBullets = 25;
        vandal.bulletCount = 25;
        vandal.damage = 45;
        vandal.accuracy = 0.8f;

        kim.gun = vandal;
        players.add(kim);
        allCharacters.add(kim);

        Player mrH = new Player();
        mrH.username = "Mr. Hernandez";

        Weapon odin = new Weapon();
        odin.weaponName = "odin";
        odin.maxBullets = 100;
        odin.bulletCount = 100;
        odin.damage = 60;
        odin.accuracy = 0.25f;

        mrH.gun = odin;
        players.add(mrH);
        allCharacters.add(mrH);

        Weapon p80 = new Weapon();
        p80.weaponName = "P80";
        p80.maxBullets = 17;
        p80.bulletCount = 17;
        p80.damage = 40;
        p80.accuracy = 0.7f;

        NPC john = new NPC();
        john.username = "John";

        john.gun = p80;
        npcs.add(john);
        allCharacters.add(john);

        Weapon guardian = new Weapon();
        guardian.weaponName = "Guardian";
        guardian.maxBullets = 12;
        guardian.bulletCount = 12;
        guardian.damage = 75;
        guardian.accuracy = 0.8f;

        NPC robocop = new NPC();
        robocop.username = "Robo Cop";

        robocop.gun = guardian;
        npcs.add(robocop);
        allCharacters.add(robocop);

        Weapon m1911 = new Weapon();
        m1911.weaponName = "M1911";
        m1911.maxBullets = 12;
        m1911.bulletCount = 12;
        m1911.damage = 25;
        m1911.accuracy = 0.2f;

        NPC alex = new NPC();
        alex.username = "Alex";

        alex.gun = m1911;
        npcs.add(alex);
        allCharacters.add(alex);

        Weapon samosa = new Weapon();
        samosa.weaponName = "Samosa";
        samosa.maxBullets = 1;
        samosa.bulletCount = 1;
        samosa.damage = 2;
        samosa.accuracy = 0.7f;

        NPC shoeb = new NPC();
        shoeb.username = "Shoeb";

        shoeb.gun = samosa;
        npcs.add(shoeb);
        allCharacters.add(shoeb);

        Weapon bow = new Weapon();
        bow.weaponName = "Bow";
        bow.maxBullets = 1;
        bow.bulletCount = 1;
        bow.damage = 90;
        bow.accuracy = 0.4f;

        NPC tom = new NPC();
        tom.username = "Tom";

        tom.gun = bow;
        npcs.add(tom);
        allCharacters.add(tom);

        weapons.add(bow);
        weapons.add(vandal);
        weapons.add(guardian);
        weapons.add(samosa);
        weapons.add(p80);
        weapons.add(odin);
        weapons.add(m1911);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                int target = random.nextInt(0, 2);
                int npcIndex = random.nextInt(0,npcs.size());
                NPC npc = npcs.get(npcIndex);
                Character player = null;
                while (!npc.alive) {
                    npcIndex = random.nextInt(0,players.size());
                    npc = npcs.get(npcIndex);
                }
                if (target == 0) {
                    int playerIndex = random.nextInt(0,players.size());
                    player = players.get(playerIndex);
                    while (!player.alive) {
                        playerIndex = random.nextInt(0,players.size());
                        player = players.get(playerIndex);
                    }
                } else {
                    int playerIndex = random.nextInt(0,npcs.size());
                    player = npcs.get(playerIndex);
                    while (!player.alive) {
                        playerIndex = random.nextInt(0,npcs.size());
                        player = npcs.get(playerIndex);
                    }
                }

                npc.action(player);
                npc.status();
            }
            else {
                int playerIndex = random.nextInt(0,players.size());
                Player player = players.get(playerIndex);
                while (!player.alive) {
                    playerIndex = random.nextInt(0,players.size());
                    player = players.get(playerIndex);
                }
                System.out.println(player.username + " Move Menu:\n1. Shoot NPC\n2. Shoot Player\n3. Reload\n4. Heal");
                String choice = scanner.nextLine();
                switch (choice) {
                    case ("1") -> {
                        StringBuilder npcNames = new StringBuilder();
                        NPC npcChoice = null;
                        for (NPC npc : npcs) {
                            npcNames.append(npc.username).append("\n");
                        }

                        while (npcChoice == null) {
                            System.out.println(player.username + " Shoot Menu:\n" + npcNames);
                            String npcChoiceName = scanner.nextLine();
                            for (NPC npc : npcs) {
                                if (npc.username.equals(npcChoiceName)) {
                                    npcChoice = npc;
                                }
                            }
                        }
                        player.shoot(npcChoice);
                    }
                    case ("2") -> {
                        StringBuilder playerNames = new StringBuilder();
                        Player playerChoice = null;
                        for (Player listplayer : players) {
                            if (!listplayer.username.equals(player.username)) {
                                playerNames.append(listplayer.username).append("\n");
                            }
                        }

                        while (playerChoice == null) {
                            System.out.println(player.username + " Shoot Menu:\n" + playerNames);
                            String playerChoiceName = scanner.nextLine();
                            for (Player listplayer : players) {
                                if (listplayer.username.equals(playerChoiceName)) {
                                    playerChoice = listplayer;
                                }
                            }
                        }
                        player.shoot(playerChoice);
                    }
                    case ("3") -> {
                        player.reload();
                    }
                    default -> {
                        player.heal();
                    }
                }
                player.status();
            }
        }

        ArrayList<Character> leaderboard = new ArrayList<Character>();
        for (Character character : allCharacters) {
            // Sort leaderboard by kills
        }

    }
}