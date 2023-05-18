/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuManager;


/**
 *
 * @author USER
 */

import java.io.*;
import java.util.*;

public class MenuManager {
    private Map<String[], Integer[]> menus;
    private Map<String, Command> commands;
    private Scanner scanner;
    private String filePath;

    public MenuManager(String filePath) {
        this.filePath = filePath;
        menus = new HashMap<>();
        commands = new HashMap<>();
        scanner = new Scanner(System.in);

        commands.put("add", new AddMenuCommand(menus, scanner));
        commands.put("update", new UpdateMenuCommand(menus, scanner));
        commands.put("delete", new DeleteMenuCommand(menus, scanner));
        commands.put("show", new ShowMenuCommand(menus, scanner));
    }

    public void run() {
        loadMenusFromFile(filePath);

        while (true) {
            System.out.println("========== 메뉴 관리 ==========");
            System.out.println("1. 메뉴 추가 (add)");
            System.out.println("2. 메뉴 수정 (update)");
            System.out.println("3. 메뉴 삭제 (delete)");
            System.out.println("4. 메뉴 보기 (show)");
            System.out.println("5. 종료 (quit)");
            System.out.print("원하는 작업을 선택하세요: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("quit")) {
                break;
            }

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
                saveMenusToFile(filePath);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    private void loadMenusFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    System.out.println("잘못된 형식의 메뉴 정보입니다: " + line);
                    continue;
                }
                
                
                String menuType = parts[0].trim();
                String menuName = parts[1].trim();
                int price = Integer.parseInt(parts[2].trim());
                int stock = Integer.parseInt(parts[3].trim());
                
                
                menus.put(new String[]{menuType, menuName}, new Integer[]{price, stock});
            }
        } catch (FileNotFoundException e) {
            System.out.println("메뉴 정보 파일을 찾을 수 없습니다: " + filePath);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 메뉴 정보가 포함되어 있습니다.");
        }
    }

    private void saveMenusToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String[], Integer[]> entry : menus.entrySet()) {
                String menuType = entry.getKey()[0];
                String menuName = entry.getKey()[1];
                int price = entry.getValue()[0];
                int stock = entry.getValue()[1];
                
                
                writer.printf("%s,%s,%d,%d\n", menuType,menuName, price, stock);
                
            }
            System.out.println("메뉴 정보가 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("메뉴 정보를 저장하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }
}
