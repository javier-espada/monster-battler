public class Monster {
    private String name, type;
    private int lvl, health, speed, defense, power;
    private Attack attack;

    public Monster(String name, String type, int lvl, int health, int speed, int defense, int power, Attack) {
        this.name = name;
        this.type = type;
        this.lvl = lvl;
        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.power = power;

    }

    int defend(){
        return defense+level;
    }
    int attack(){
        return power+level;
    }
    int initiative(){
        return speed+level;
    }
}
