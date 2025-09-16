import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Player kim = new Player();
        kim.username = "Kim";

        Weapon vandal = new Weapon();
        vandal.weaponName = "Vandal";
        vandal.maxBullets = 25;
        vandal.bulletCount = 25;
        vandal.damage = 45;
        vandal.accuracy = 0.6f;

        kim.gun = vandal;
        players.add(kim);

        Weapon p80 = new Weapon();
        p80.weaponName = "P80";
        p80.maxBullets = 17;
        p80.bulletCount = 17;
        p80.damage = 40;
        p80.accuracy = 0.7f;

        NPC john = new NPC();
        john.username = "John";

        NPC robocop = new NPC();
        robocop.username = "Robo Cop";

        NPC alex = new NPC();
        alex.username = "Alex";

        NPC shoeb = new NPC();
        shoeb.username = "Shoeb";

        Weapon guardian = new Weapon();
        guardian.weaponName = "Guardian";
        guardian.maxBullets = 12;
        guardian.bulletCount = 12;
        guardian.damage = 75;
        guardian.accuracy = 0.8f;

        john.gun = p80;
        npcs.add(john);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                int npcIndex = random.nextInt(0,npcs.size());
                NPC npc = npcs.get(npcIndex);
                while (!npc.alive) {
                    npcIndex = random.nextInt(0,players.size());
                    npc = npcs.get(npcIndex);
                }
                int playerIndex = random.nextInt(0,players.size());
                Player player = players.get(playerIndex);
                while (!player.alive) {
                    playerIndex = random.nextInt(0,players.size());
                    player = players.get(playerIndex);
                }
                npc.action(player);
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



                }


                player.status();
            }
        }

    }
}