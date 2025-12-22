package map;

import monsters.Monster;

import static java.lang.Math.random;

public class TrainingSpot extends Encounter {

    public TrainingSpot(){
        this.type="TrainingSpot";
    }

    public void levelUp(Monster monster,int option){
        monster.setLevel(monster.getLevel()+1);
        monster.setHp(monster.getLevel()*monster.getHealth());

        switch(option){
            case 1:
                monster.setHealth(monster.getHealth()+1);
                break;
            case 2:
                monster.setPower(monster.getPower()+1);
                break;
            case 3:
                monster.setSpeed(monster.getSpeed()+1);
                break;
            case 4:
                monster.setDefense(monster.getDefense()+1);
                break;
            default:
                option = 1 + (int)(Math.random() * ((4 - 1) + 1));
                levelUp(monster,option);
                break;
        }
    }
}
