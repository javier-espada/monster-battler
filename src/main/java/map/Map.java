package map;

import monsters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Map {
    private List<Encounter> encounterList;
    private Monster boss, enemy, myMonster;
    private int level = 1, currentEncounter;

    void setRandomBoss() throws IOException {
        File inFile = new File("src/main/resources/Bosses.csv");
        Scanner inputFile = new Scanner(inFile);
        String str;
        String[] tokens = new String[7];
        inputFile.nextLine();
        str = inputFile.nextLine();
        tokens = str.split(";");

        String name = tokens[0];
        String type = tokens[1];
        int health = Integer.parseInt(tokens[2]);
        int power = Integer.parseInt(tokens[3]);
        int speed = Integer.parseInt(tokens[4]);
        int defense = Integer.parseInt(tokens[5]);
        int level = Integer.parseInt(tokens[6]);

        boss = new Monster(name, type, health, power, speed, defense, level);
    }

    void setRandomEnemy() throws IOException {
        File inFile = new File("src/main/resources/Monsters.csv");
        Scanner inputFile = new Scanner(inFile);
        String str;
        String[] tokens= new String[7];
        inputFile.nextLine();
        inputFile.nextLine();
        str = inputFile.nextLine();
        tokens = str.split(";");

        String name = tokens[0];
        String type = tokens[1];
        int health = Integer.parseInt(tokens[2]);
        int power = Integer.parseInt(tokens[3]);
        int speed = Integer.parseInt(tokens[4]);
        int defense = Integer.parseInt(tokens[5]);
        int level = Integer.parseInt(tokens[6]);

        enemy = new Monster(name, type, health, power, speed, defense, level);
    }

    void setMyMonster() throws IOException {
        String name = "Pet";
        String type = "Fire";
        int health = 2;
        int power = 2;
        int speed = 2;
        int defense = 2;
        int level = 1;

        myMonster = new Monster(name, type, health, power, speed, defense, level);
    }

    public void createMap () throws IOException{
        encounterList = new ArrayList<>();
        setMyMonster();

        for (int i = 0; i < level + 3; i++) {
            currentEncounter = (int) (Math.random() * 3)+1;
            switch (currentEncounter){
                case 2:
                    encounterList.add(new RestSite(myMonster));
                    break;
                case 3:
                    encounterList.add(new TrainingSpot(myMonster));
                    break;
                default:
                    setRandomEnemy();
                    encounterList.add(new Battle(enemy, myMonster));
                    break;
            }
        }
        setRandomBoss();
        encounterList.add(new Battle(boss, myMonster));
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Encounter> getEncounterList() {
        return encounterList;
    }

    public int getCurrentEncounter() {
        return currentEncounter;
    }

    public void setCurrentEncounter(int currentEncounter) {
        this.currentEncounter = currentEncounter;
    }

    public Monster getMyMonster() {
        return myMonster;
    }

    public Monster getBoss() {
        return boss;
    }
}
