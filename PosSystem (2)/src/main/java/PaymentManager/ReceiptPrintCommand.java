/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManager;

/**
 *
 * @author USER
 */
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class ReceiptPrintCommand implements Command{
    private Map<String, Integer[]> menus;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public ReceiptPrintCommand(Map<String, Integer[]> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void execute() {
        System.out.println("========== 영수증 ==========");
        System.out.print("결제 번호를 입력하세요: ");
        String paymentNumber = scanner.nextLine().trim();

        Integer[] menu = menus.get(paymentNumber);
        if (menu != null) {
            System.out.println("결제 일시: " + dateFormat.format(new Date()));
            System.out.println("결제 번호: " + paymentNumber);
            System.out.println("메뉴 이름: " + menu[0]);
            System.out.println("메뉴 가격: " + menu[1] + "원");
            System.out.println("=============================");
        } else {
            System.out.println("결제 번호에 해당하는 메뉴 정보를 찾을 수 없습니다.");
        }
    }
}
