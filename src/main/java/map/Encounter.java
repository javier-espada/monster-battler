package map;

import monsters.Monster;

public class Encounter {
    String type;
    Monster myMonster;

    public Encounter(Monster myMonster){
        this.myMonster = myMonster;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Monster getMyMonster() {
        return myMonster;
    }
    public void setMyMonster(Monster myMonster) {
        this.myMonster = myMonster;
    }
}
