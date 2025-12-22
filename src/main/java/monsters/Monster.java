package monsters;

public class Monster {
    private String name, type;
    private int level, health, speed, defense, power, hp;

    public Monster(String name, String type, int level, int health, int speed, int defense, int power) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.power = power;
        hp = health*level;
    }

    public int defend(){
        return defense+level;
    }
    public int attack(){
        return power+level;
    }
    public int initiative(){
        return speed+level;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}

