package map;

import monsters.Monster;

public class Battle extends Encounter {
    private Monster enemy;

    public Battle(Monster enemy){
        this.type="Battle";
        this.enemy=enemy;
    }

    Monster compareInitiative(Monster monster1, Monster monster2) {
        if(monster1.initiative()>monster2.initiative()){
            return monster1;
        } else if(monster2.initiative()>monster1.initiative()){
            return monster2;
        }
        return monster1;
    }
    void attackMonster(Monster monster1, Monster monster2) {
        monster2.setHp(monster2.getHp()-(monster1.attack()-monster2.defend()));
    }
    void battleMonster(Monster monster1) {
        while(monster1.getHp()>0 && enemy.getHp()>0){
            if(compareInitiative(monster1,enemy)==monster1){
                attackMonster(monster1,enemy);
            }else{
                attackMonster(enemy,monster1);
            }
        }
    }
}
