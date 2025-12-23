package menus;


import map.Battle;
import map.Map;
import map.RestSite;
import map.TrainingSpot;
import map.Encounter;

import java.io.IOException;
import java.util.Scanner;

public class MapMenu {
    Map map;
    public MapMenu(Map map){
        this.map = map;
    }

    int option;
    public void run() throws IOException {
        map.createMap();
        for(int i=0; i<map.getEncounterList().size(); i++) {
            System.out.println("Welcome to lvl" + map.getLevel());
            System.out.println("What do you wanna do:");
            System.out.println("1. Explore the next encounter:");
            System.out.println("2. Face the boss:");
            System.out.println("3. Check stats");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Let's explore:");
                    String encounterType = map.getEncounterList().get(map.getCurrentEncounter()+i).getType();
                    switch (encounterType) {
                        case "Battle":
                            System.out.println("It's a battle!");
                            BattleMenu battleMenu = new BattleMenu((Battle) map.getEncounterList().get(map.getCurrentEncounter()+i));

                            battleMenu.run();
                            if(((Battle) map.getEncounterList().get(map.getCurrentEncounter()+i)).getEnemy()==map.getBoss()){
                                System.out.println("You won!");
                                System.exit(0);
                            }
                            System.out.println("Do you want to capture the monster?");
                            System.out.println("y/n");
                            Scanner sc2 = new Scanner(System.in);
                            char capture = sc2.next().charAt(0);
                            switch (capture) {
                                case 'y':
                                    map.setMyMonster(((Battle) map.getEncounterList().get(map.getCurrentEncounter() + i)).getEnemy());
                                    for (Encounter encounter:map.getEncounterList()) {
                                        encounter.setMyMonster(map.getMyMonster());
                                    }
                                    break;
                                default:
                                    break;
                            }

                            break;
                        case "Rest":
                            System.out.println("It's a rest site!");
                            System.out.println("You fully heal");
                            RestSite.healMonster(map.getMyMonster());
                            break;
                        case "Training":
                            System.out.println("It's a training site!");
                            System.out.println("1. Upgrade Health");
                            System.out.println("2. Upgrade Power");
                            System.out.println("3. Upgrade Speed");
                            System.out.println("4. Upgrade Defense");
                            int trainOption = sc.nextInt();
                            sc.nextLine();
                            TrainingSpot.levelUp(map.getMyMonster(), trainOption);
                            break;

                    }

                break;
                case 2:

                    System.out.println("Let's face the boss!:");
                    BattleMenu battleMenu = new BattleMenu((Battle) map.getEncounterList().get(map.getEncounterList().size()-1));
                    battleMenu.run();
                    System.out.println("You won!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Your monster is:" + map.getMyMonster().getName());
                    System.out.println("Level: " + map.getLevel());
                    System.out.println("HP: " + map.getMyMonster().getHp());
                    System.out.println("Health: " + map.getMyMonster().getSpeed());
                    System.out.println("Power: " + map.getMyMonster().getDefense());
                    System.out.println("Speed: " + map.getMyMonster().getDefense());
                    System.out.println("Defense: " + map.getMyMonster().getDefense());

            }
        }
    }
}
