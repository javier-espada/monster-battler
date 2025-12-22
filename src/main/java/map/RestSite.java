package map;

import monsters.Monster;

public class RestSite extends Encounter {
    public RestSite(){
        this.type="Rest";
    }

    public void healMonster(Monster monster){
        monster.setHp(monster.getLevel()*monster.getHealth());
    }
}
