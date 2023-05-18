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

public class DeleteMenuCommand implements Command {

    private Map<String[], Integer[]> menus;
    private Scanner scanner;

    public DeleteMenuCommand(Map<String[], Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("========== 메뉴 삭제 ==========");
        System.out.print("삭제할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();

        boolean menuDeleted = false;
        for (String[] menu : menus.keySet()) {
            if (menu[1].equals(menuName)) {
                menus.remove(menu);
                menuDeleted = true;
                System.out.println("메뉴가 삭제되었습니다.");
                System.out.println("===============================");
                break;
            }
        }
        
        if (!menuDeleted) {
            System.out.println("존재하지 않는 메뉴입니다.");
        }
    }
}
