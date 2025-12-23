package map;

import monsters.Monster;

public class Battle extends Encounter {
    private Monster enemy;

    public Battle(Monster enemy,  Monster myMonster){
        super(myMonster);
        this.type="Battle";
        this.enemy=enemy;
    }

    public static Monster compareInitiative(Monster monster1, Monster monster2) {
        if(monster1.initiative()>monster2.initiative()){
            return monster1;
        } else if(monster2.initiative()>monster1.initiative()){
            return monster2;
        }
        return monster1;
    }
    void attackMonster(Monster monster1, Monster monster2) {
        monster2.setHp(monster2.getHp()-(monster1.attack()-monster2.defend()+5));
        System.out.println(monster2.getName() + " was attacked! It received "+ (monster1.attack()-monster2.defend()) + " damage!");
    }
    public Monster battleMonster(Monster monster1) {
        while(monster1.getHp()>0 && enemy.getHp()>0){
            if(compareInitiative(monster1,enemy)==monster1){
                attackMonster(monster1,enemy);
                attackMonster(enemy,monster1);
            }else{
                attackMonster(enemy,monster1);
                attackMonster(monster1,enemy);
            }
        }
        if(enemy.getHp()<=0){
            return monster1;
        }
        else if(monster1.getHp()<=0){
            return enemy;
        }

        return monster1;
    }

    public Monster getEnemy() {
        return enemy;
    }
}
