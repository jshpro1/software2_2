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

public class Menu {
    public void addMenu(Map<String[], Integer[]> menus, Scanner scanner) {
        System.out.println("========== 메뉴 추가 ==========");

        System.out.print("카테고리를 입력하세요: ");
        String menuType = scanner.nextLine().trim();

        System.out.print("추가할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();

        // 중복 체크
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

    public void deleteMenu(Map<String[], Integer[]> menus, Scanner scanner) {
        System.out.println("========== 메뉴 삭제 ==========");
        System.out.print("삭제할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();

        boolean menuDeleted = false;
        for (Iterator<Map.Entry<String[], Integer[]>> iterator = menus.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String[], Integer[]> entry = iterator.next();
            if (entry.getKey()[1].equals(menuName)) {
                iterator.remove();
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

    public void updateMenu(Map<String[], Integer[]> menus, Scanner scanner) {
        System.out.println("========== 메뉴 수정 ==========");

        System.out.print("수정할 메뉴 이름을 입력하세요: ");
        String menuName = scanner.nextLine().trim();

        // 메뉴 유무 판정
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

    public void showMenu(Map<String[], Integer[]> menus) {
        System.out.println("========== 현재 메뉴 목록 ==========");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "카테고리", "메뉴명", "가격", "재고");

        for (Map.Entry<String[], Integer[]> entry : menus.entrySet()) {
            String menuType = entry.getKey()[0];
            String menuName = entry.getKey()[1];
            int price = entry.getValue()[0];
            int stock = entry.getValue()[1];

            System.out.printf("%-10s %-10s %-10d %-10d\n", menuType, menuName, price, stock);
        }

        System.out.println("==================================");
    }
}