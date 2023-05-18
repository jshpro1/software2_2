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

public class AddMenuCommand implements Command{
    private Map<String[], Integer[]> menus;
    private Scanner scanner;

    public AddMenuCommand(Map<String[], Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("========== 메뉴 추가 ==========");
        
        System.out.print("카테고리를 입력하세요: ");
        String menuType = scanner.nextLine().trim();
        
        System.out.print("추가할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();
        
        //중복 체크
        for (String[] menu : menus.keySet()) {
            if (menu[1].equals(menuName)) {
                System.out.println("이미 존재하는 메뉴입니다.");
                return;
            }
        }

        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("재고를 입력하세요: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        menus.put(new String[]{menuType, menuName}, new Integer[]{price, stock});
        System.out.println("메뉴가 추가되었습니다.");
        System.out.println("===============================");
    }
}
