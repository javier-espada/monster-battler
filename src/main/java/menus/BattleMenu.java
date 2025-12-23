package menus;

import map.Battle;
import map.Encounter;
import monsters.Monster;

public class BattleMenu {
    Battle battle;
    public BattleMenu(Battle battle) {
        this.battle = battle;
    }
    void run(){
        System.out.println("There is a " + battle.getEnemy().getName() + "blocking your way!");
        if(Battle.compareInitiative(battle.getMyMonster(),battle.getEnemy())==battle.getMyMonster()){
            System.out.println("You are faster! Let's attack!");
        } else {
            System.out.println("It's faster! Brace for impact!");
        }
        if(battle.battleMonster(battle.getMyMonster())==battle.getMyMonster()){
            System.out.println("You won! Let's keep going!");
        } else {
            System.out.println("You lost! More luck next time");
            System.exit(0);
        };
    }
}
