/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManager;

/**
 *
 * @author USER
 */
import java.util.*;
import java.util.*;

public class ShowMenuCommand implements Command {
    private Menu menu;
    private Map<String[], Integer[]> menus;

    public ShowMenuCommand(Map<String[], Integer[]> menus) {
        this.menu = new Menu();  // Initialize the menu object
        this.menus = menus;
    }

    public void execute() {
        menu.showMenu(menus);
    }
}
