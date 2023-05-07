package OrderManager;


/**
 *  5/7
 * @author jsh
 * 
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import java.io.*;

public class OrderManagement {

    public static void main(String[] args) {
        String itemFile = "items.txt";
        String salesFile = "sales.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(itemFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(salesFile, true)); 
            
            // 물품 정보를 읽어서 아이템 배열에 저장
            String line;
            Item[] items = new Item[100]; // 최대 100개의 물품 저장 가능
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length != 3) {
                    throw new Exception("잘못된 데이터 포맷입니다: " + line);
                }
                String name = tokens[0].trim();
                int price = Integer.parseInt(tokens[1].trim());
                int stock = Integer.parseInt(tokens[2].trim());
                items[count] = new Item(name, price, stock);
                count++;
            }
            reader.close();
            
            // 사용자 입력 처리
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("물품명을 입력하세요 (종료는 q): ");
                String name = in.readLine().trim();
                if (name.equals("q")) {
                    break;
                }
                
                // 물품 검색
                Item item = null;
                for (int i = 0; i < count; i++) {
                    if (items[i].getName().equals(name)) {
                        item = items[i];
                        break;
                    }
                }
                if (item == null) {
                    System.out.println("해당 물품이 존재하지 않습니다.");
                    continue;
                }
                
                System.out.print("수량을 입력하세요: ");
                int quantity = Integer.parseInt(in.readLine().trim());
                if (quantity > item.getStock()) {
                    System.out.println("재고가 부족합니다. 현재 재고: " + item.getStock());
                    continue;
                }
                
                // 판매 기록 저장
                int totalPrice = item.getPrice() * quantity;
                writer.write(item.getName() + "," + quantity + "," + totalPrice);
                writer.newLine();
                writer.flush();
                
                // 재고 갱신
                item.setStock(item.getStock() - quantity);
                
                System.out.println("주문이 완료되었습니다. 총액: " + totalPrice);
            }
            in.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Item {
    private String name;
    private int price;
    private int stock;
    
    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
}
