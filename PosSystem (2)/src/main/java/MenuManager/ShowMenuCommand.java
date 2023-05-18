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

public class ShowMenuCommand implements Command {

    private Map<String[], Integer[]> menus;
    private Scanner scanner;

    public ShowMenuCommand(Map<String[], Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    public void execute() {

        System.out.println("========== 현재 메뉴 목록 ==========");
        System.out.printf("%-10s %-10s %-10s %-10s\n","카테고리","메뉴명", "가격", "재고");

        for (Map.Entry<String[], Integer[]> entry : menus.entrySet()) {
            String menuType = entry.getKey()[0];
            String menuName = entry.getKey()[1];
            int price = entry.getValue()[0];
            int stock = entry.getValue()[1];

            System.out.printf("%-10s %-10s %-10d %-10d\n",menuType,menuName, price, stock);
        }

        System.out.println("==================================");
    }
}
