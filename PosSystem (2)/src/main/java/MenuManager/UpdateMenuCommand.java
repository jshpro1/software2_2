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

public class UpdateMenuCommand implements Command {

    private Map<String[], Integer[]> menus;
    private Scanner scanner;

    public UpdateMenuCommand(Map<String[], Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("========== 메뉴 수정 ==========");

        System.out.print("수정할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();
        
        //메뉴 유무 판정
        boolean menuExists = false;
        for (String[] menu : menus.keySet()) {
            if (menu[1].equals(menuName)) {
                
                menuExists = true;
                System.out.print("카테고리: ");
                String menuType = scanner.nextLine().trim();

                System.out.print("가격: ");
                int newPrice = scanner.nextInt();
                scanner.nextLine();

                System.out.print("재고: ");
                int newStock = scanner.nextInt();
                scanner.nextLine();

                menus.put(new String[]{menuType, menuName}, new Integer[]{newPrice, newStock});
                System.out.println("메뉴가 수정되었습니다.");
                System.out.println("===============================");
                break;
            }
        }
        if (!menuExists) {
            System.out.println("존재하지 않는 메뉴입니다.");
        }
    }
}
