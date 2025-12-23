package Main;

import map.Map;
import menus.MapMenu;
import monsters.Monster;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {
        Map map = new Map();
        MapMenu mapMenu = new MapMenu(map);
        mapMenu.run();
    }
}
