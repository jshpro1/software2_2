/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManager;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        String filePath = "menus.txt";
        MenuManager menuManager = new MenuManager(filePath);
        menuManager.run();
    }
}
