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

        Weapon vandal = new Weapon();
        vandal.weaponName = "Vandal";
        vandal.maxBullets = 25;
        vandal.bulletCount = 25;
        vandal.damage = 45;
        vandal.accuracy = 0.8f;

        Player kim = new Player("Kim", 0, true, vandal, 100);
        players.add(kim);
        allCharacters.add(kim);

        Player mrH = new Player();
        mrH.setUsername("Mr. Hernandez");
        mrH.setKills(0);
        mrH.setAlive(true);
        mrH.setHp(100);

        Weapon odin = new Weapon();
        odin.weaponName = "odin";
        odin.maxBullets = 100;
        odin.bulletCount = 100;
        odin.damage = 20;
        odin.accuracy = 0.9f;

        mrH.setGun(odin);
        players.add(mrH);
        allCharacters.add(mrH);

        Weapon p80 = new Weapon();
        p80.weaponName = "P80";
        p80.maxBullets = 17;
        p80.bulletCount = 17;
        p80.damage = 40;
        p80.accuracy = 0.7f;

        NPC john = new NPC();
        john.setUsername("John");
        john.setKills(0);
        john.setAlive(true);
        john.setHp(100);

        john.setGun(p80);
        npcs.add(john);
        allCharacters.add(john);

        Weapon guardian = new Weapon();
        guardian.weaponName = "Guardian";
        guardian.maxBullets = 12;
        guardian.bulletCount = 12;
        guardian.damage = 75;
        guardian.accuracy = 0.8f;

        NPC robocop = new NPC();
        robocop.setUsername("Robo Cop");
        robocop.setKills(0);
        robocop.setAlive(true);
        robocop.setHp(100);
        robocop.setGun(guardian);
        npcs.add(robocop);
        allCharacters.add(robocop);

        Weapon m1911 = new Weapon();
        m1911.weaponName = "M1911";
        m1911.maxBullets = 12;
        m1911.bulletCount = 12;
        m1911.damage = 25;
        m1911.accuracy = 0.2f;

        NPC alex = new NPC();
        alex.setUsername("Alex");
        alex.setKills(0);
        alex.setAlive(true);
        alex.setHp(100);
        alex.setGun(m1911);
        npcs.add(alex);
        allCharacters.add(alex);

        Weapon samosa = new Weapon();
        samosa.weaponName = "Samosa";
        samosa.maxBullets = 1;
        samosa.bulletCount = 1;
        samosa.damage = 2;
        samosa.accuracy = 0.7f;

        NPC shoeb = new NPC();
        shoeb.setUsername("Shoeb");
        shoeb.setKills(0);
        shoeb.setAlive(true);
        shoeb.setHp(100);
        shoeb.setGun(samosa);
        npcs.add(shoeb);
        allCharacters.add(shoeb);

        Weapon bow = new Weapon();
        bow.weaponName = "Bow";
        bow.maxBullets = 1;
        bow.bulletCount = 1;
        bow.damage = 90;
        bow.accuracy = 0.4f;

        NPC tom = new NPC();
        tom.setUsername("Tom");
        tom.setKills(0);
        tom.setAlive(true);
        tom.setHp(100);
        tom.setGun(bow);
        npcs.add(tom);
        allCharacters.add(tom);

        weapons.add(bow);
        weapons.add(vandal);
        weapons.add(guardian);
        weapons.add(samosa);
        weapons.add(p80);
        weapons.add(odin);
        weapons.add(m1911);

        System.out.println("Game Starts!");
        System.out.print(kim);

        for (int i = 0; i < 100; i++) {
            int aliveCount = 0;
            for (Character character : allCharacters) {
                if (character.isAlive()) {
                    aliveCount++;
                }
            }

            System.out.println("\nPlayers Alive: " + aliveCount);

            if (aliveCount == 1) {
                System.out.println("\nGAME OVER!");
                break;
            }

            System.out.println("\nTurn: " + i);

            if (i % 2 == 0) {
                if (!npcs.isEmpty()) {
                    int target = random.nextInt(0,2);
                    int npcIndex = random.nextInt(0, npcs.size());
                    NPC npc = npcs.get(npcIndex);
                    Character player = null;
                    while (!npc.isAlive()) {
                        npcs.remove(npcIndex);
                        if (npcs.isEmpty()) {
                            break;
                        } else {
                            npcIndex = random.nextInt(0, npcs.size());
                            npc = npcs.get(npcIndex);
                        }
                    }
                    if (npc.isAlive()) {
                        if (target == 0) {
                            if (!players.isEmpty()) {
                                int playerIndex = random.nextInt(0, players.size());
                                player = players.get(playerIndex);
                                while (!player.isAlive()) {
                                    players.remove(playerIndex);
                                    if (players.isEmpty()) {
                                        break;
                                    } else {
                                        playerIndex = random.nextInt(0, players.size());
                                        player = players.get(playerIndex);
                                    }
                                }
                            }
                        } else {
                            if (!npcs.isEmpty()) {
                                int playerIndex = random.nextInt(0, npcs.size());
                                player = npcs.get(playerIndex);
                            }
                        }

                        npc.action(player);
                        npc.status();
                    }
                }
            }
            else {
                if (!players.isEmpty()) {
                    int playerIndex = random.nextInt(0,players.size());
                    Player player = players.get(playerIndex);
                    while (!player.isAlive()) {
                        players.remove(playerIndex);
                        if (!players.isEmpty()) {
                            playerIndex = random.nextInt(0,players.size());
                            player = players.get(playerIndex);
                        } else {
                            break;
                        }
                    }

                    if (player.isAlive()) {
                        System.out.println("\n" + player.getUsername() + " Move Menu:\n1. Shoot NPC\n2. Shoot Player\n3. Reload\n4. Heal");
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case ("1") -> {
                                StringBuilder npcNames = new StringBuilder();
                                NPC npcChoice = null;
                                for (NPC npc : npcs) {
                                    if (npc.isAlive()) {
                                        npcNames.append(npc.getUsername()).append("\n");
                                    }
                                }

                                while (npcChoice == null) {
                                    System.out.println("\n" + player.getUsername() + " Shoot Menu:\n" + npcNames);
                                    String npcChoiceName = scanner.nextLine();
                                    for (NPC npc : npcs) {
                                        if (npc.getUsername().equals(npcChoiceName)) {
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
                                    if (!listplayer.getUsername().equals(player.getUsername())) {
                                        if (listplayer.isAlive()) {
                                            playerNames.append(listplayer.getUsername()).append("\n");
                                        }
                                    }
                                }

                                while (playerChoice == null) {
                                    System.out.println("\n" + player.getUsername() + " Shoot Menu:\n" + playerNames);
                                    String playerChoiceName = scanner.nextLine();
                                    for (Player listplayer : players) {
                                        if (listplayer.getUsername().equals(playerChoiceName)) {
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
            }
        }

        allCharacters.sort((c1, c2) -> Integer.compare(c2.getKills(), c1.getKills()));

        System.out.println("\n=== LEADERBOARD ===");
        for (int i = 0; i < allCharacters.size(); i++) {
            Character character = allCharacters.get(i);
            System.out.println((i + 1) + ". " + character.getUsername() +
                    " - Kills: " + character.getKills());
        }

    }
}