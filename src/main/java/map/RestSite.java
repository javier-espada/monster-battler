package map;

import monsters.Monster;

public class RestSite extends Encounter {
    public RestSite(Monster myMonster){
        super(myMonster);
        this.type="Rest";
    }

    public static void healMonster(Monster monster){
        monster.setHp(monster.getLevel()*monster.getHealth());
    }
}
