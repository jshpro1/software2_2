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
import java.text.*;

public class CardPayCommand implements Command{
    private static int paymentCount = 0; // 결제 번호를 자동으로 생성하기 위한 변수
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public CardPayCommand(Scanner scanner) {
        this.scanner = scanner;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void execute() {
        System.out.print("카드 번호를 입력하세요: ");
        String cardNumber = scanner.nextLine().trim();

        System.out.print("결제 금액을 입력하세요: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        // Payment process with card payment goes here...

        System.out.println("카드로 결제되었습니다.");

        int paymentNumber = generatePaymentNumber(); // 결제 번호 생성
        savePaymentInfo(paymentNumber, cardNumber, "카드결제", amount);
    }
    
    private int generatePaymentNumber() {
        return ++paymentCount;
    }

    private void savePaymentInfo(int paymentNumber, String cardNumber, String paymentMethod, int amount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("payinfo.txt", true))) {
            writer.println("결제 번호: " + paymentNumber);
            writer.println("결제 일시: " + dateFormat.format(new Date()));
            writer.println("카드 번호: " + cardNumber);
            writer.println("결제 방법: " + paymentMethod);
            writer.println("결제 금액: " + amount + "원");
            writer.println("===============================");
        } catch (IOException e) {
            System.out.println("결제 정보를 저장하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }
}
