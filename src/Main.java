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

        NPC john = new NPC();
        john.NPCname = "John";

        Weapon guardian = new Weapon();
        guardian.weaponName = "Guardian";
        guardian.maxBullets = 12;
        guardian.bulletCount = 12;
        guardian.damage = 75;
        guardian.accuracy = 0.8f;

        john.gun = guardian;

        npcs.add(john);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                int npcIndex = random.nextInt(0,npcs.size());
                int playerIndex = random.nextInt(0,players.size());
                npcs.get(npcIndex).action(players.get(playerIndex));
            }
            else {
                int playerIndex = random.nextInt(0,players.size());
                Player player = players.get(playerIndex);
                System.out.println(player.username + " Move Menu:\n1. Shoot NPC\n2. Shoot Player\n3. Reload\n4. Heal");
                String choice = scanner.nextLine();
                switch (choice) {
                    case ("1") -> {
                        StringBuilder npcNames = new StringBuilder();
                        for (NPC npc : npcs) {
                            npcNames.append(npc.NPCname).append("\n");
                        }
                        System.out.println(player.username + " Shoot Menu:\n" + npcNames);
                        String npcChoiceName = scanner.nextLine();
                        NPC npcChoice = null;

                        for (NPC npc : npcs) {
                            if npc.NPCname
                        }
                    }



                }


                player.status();
            }
        }

    }
}