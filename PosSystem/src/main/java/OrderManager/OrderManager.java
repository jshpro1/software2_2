package OrderManager;

/**
 * 5/7
 *
 * @author jsh
 *
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderManager {
     private static final String ITEM_FILE_PATH = "item.txt";
     private static final String SALES_FILE_PATH = "sales.txt";
    public static void main(String[] args) {
        Map<String, Integer[]> items = readItemsFromFile(ITEM_FILE_PATH);
        if (items == null) {
            System.out.println("물품 정보를 불러오는 중 오류가 발생했습니다.");
            return;
        }

        Map<String, Integer[]> sales = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showItems(items);
            System.out.print("판매할 물품을 입력하세요 (q: 판매 종료): ");
            String itemName = scanner.nextLine().trim();

            if (itemName.equals("q")) {
                break;
            }

            Integer[] itemInfo = items.get(itemName);
            if (itemInfo == null) {
                System.out.println("존재하지 않는 물품입니다.");
                continue;
            }

            int itemPrice = itemInfo[0];
            int itemStock = itemInfo[1];
            if (itemStock == 0) {
                System.out.println("재고가 부족합니다.");
                continue;
            }

            System.out.print("판매할 수량을 입력하세요: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity <= 0 || quantity > itemStock) {
                System.out.println("올바르지 않은 수량입니다.");
                continue;
            }

            int totalPrice = itemPrice * quantity;
            items.put(itemName, new Integer[]{itemPrice, itemStock - quantity});
            addSaleRecord(sales, itemName, itemPrice, quantity, totalPrice);
            
            System.out.println("판매가 완료되었습니다.");
            System.out.println("총 판매 금액: " + totalPrice + "원");
            System.out.println();
        } 
        
        if (writeItemsToFile(items, ITEM_FILE_PATH)) {
            System.out.println("물품 정보가 업데이트되었습니다.");
        } else {
            System.out.println("물품 정보 업데이트에 실패했습니다.");
        }
        
        if (writeSalesToFile(sales, SALES_FILE_PATH)) {
            System.out.println("판매 정보가 저장되었습니다.");
        } else {
            System.out.println("판매 정보를 저장하는 중 오류가 발생했습니다.");
        }
    }

    private static Map<String, Integer[]> readItemsFromFile(String filePath) {
        Map<String, Integer[]> items = new HashMap<>();

        try ( Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length != 3) {
                    System.out.println("잘못된 형식의 물품 정보입니다: " + line);
                    return null;
                }

                String itemName = parts[0].trim();
                int itemPrice = Integer.parseInt(parts[1].trim());
                int itemStock = Integer.parseInt(parts[2].trim());

                items.put(itemName, new Integer[]{itemPrice, itemStock});
            }
        } catch (FileNotFoundException e) {
            System.out.println("물품 정보 파일을 찾을 수 없습니다: " + filePath);
            return null;
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 물품 정보가 포함되어 있습니다.");
            return null;
        }

        return items;
    }

    private static void showItems(Map<String, Integer[]> items) {
        System.out.println("========== 현재 물품 목록 ==========");
        System.out.printf("%-20s %-10s %-10s\n", "물품명", "가격", "재고");

        for (Map.Entry<String, Integer[]> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int itemPrice = entry.getValue()[0];
            int itemStock = entry.getValue()[1];

            System.out.printf("%-20s %-10d %-10d\n", itemName, itemPrice, itemStock);
        }

        System.out.println("===================================");
    }

    private static void addSaleRecord(Map<String, Integer[]> sales, String itemName, int itemPrice, int quantity, int totalPrice) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        sales.put(itemName+ "," + date , new Integer[]{itemPrice, quantity, totalPrice});
    }

    private static boolean writeItemsToFile(Map<String, Integer[]> items, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (String itemName : items.keySet()) {
                Integer[] itemInfo = items.get(itemName);
                pw.printf("%s,%d,%d\n", itemName, itemInfo[0], itemInfo[1]);
            }
            return true;
        } catch (IOException e) {
            System.out.println("물품 정보를 저장하는 데 실패했습니다.");
            e.printStackTrace();
            return false;
        }
    }


    private static boolean writeSalesToFile(Map<String, Integer[]> sales, String filePath) {
        try ( PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            for (Map.Entry<String, Integer[]> entry : sales.entrySet()) {
                String date = entry.getKey();
                int itemPrice = entry.getValue()[0];
                int quantity = entry.getValue()[1];
                int totalPrice = entry.getValue()[2];

                writer.printf("%s,%d,%d,%d\n", date, itemPrice, quantity, totalPrice);
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
