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

public class UpdateMenuCommand implements Command{
    private Menu menu;
    private Map<String[], Integer[]> menus;
    private Scanner scanner;

    public UpdateMenuCommand(Map<String[], Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }
    
    public void execute(){
        menu.updateMenu(menus, scanner);
    }
}
