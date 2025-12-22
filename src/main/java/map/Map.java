package map;

import monsters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Map {
    private List<Encounter> encounterList;
    private Monster boss, enemy;
    private int level, currentEncounter;

    void setRandomBoss() throws IOException {
        try(FileInputStream file = new FileInputStream("../../resources/Monsters.xlsx")){}
    }

    void setRandomEnemy() throws IOException {
        try(FileInputStream file = new FileInputStream("../../resources/Monsters.xlsx")){}
    }

    void createMap () throws IOException{
        encounterList = new ArrayList<>();

        for (int i = 0; i < level; i++) {
            currentEncounter = (int) (Math.random() * 3)+1;
            switch (currentEncounter){
                case 1:
                    setRandomEnemy();
                    encounterList.add(new Battle(enemy));
                    break;
                case 2:
                    encounterList.add(new RestSite());
                    break;
                case 3:
                    encounterList.add(new TrainingSpot());
                    break;
                default:
                    setRandomEnemy();
                    encounterList.add(new Battle(enemy));
                    break;
            }
        }
        setRandomBoss();
        encounterList.add(new Battle(boss));
    }

    public int getLevel() {
        return level;
    }
}
