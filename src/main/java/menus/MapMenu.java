package menus;

public class MapMenu {
    Map map = new Map();
    int option;
    run(){
        while(true) {
            System.out.println("Welcome to lvl" + map.getLevel());
            System.out.println("What do you wanna do:");
            System.out.println("1. Explore the next encounter:");
            System.out.println("2. Face the boss:");
            Scanner sc = new Scanner();
            option = sc.nextInt();
            sc.nextLine();
        }
    }
}
