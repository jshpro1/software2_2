/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManager;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.*;

public class PaymentManager {
    private double price;
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Command> commands = new HashMap<>();

    public PaymentManager() {
        commands.put("card", new CardPayCommand(price));
        commands.put("cash", new CashPayCommand());
        commands.put("mobile", new MobilePayCommand());
        commands.put("receipt", new ReceiptCommand(scanner));
    }

    public void start() {
        while (true) {
            System.out.println("========== 결제 관리 ==========");
            System.out.println("1. 카드 결제 (card)");
            System.out.println("2. 현금 결제 (cash)");
            System.out.println("3. 모바일 결제 (mobile)");
            System.out.println("4. 영수증 출력 (receipt)");
            System.out.println("5. 종료 (quit)");
            System.out.print("원하는 작업을 선택하세요: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("quit")) {
                break;
            }

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }
    
    public void GUIstart(String payType){
        Command command = commands.get(payType);
            if (command != null) {
                command.execute();
            } else if(payType.equals("quit")){
                System.out.println("시스템을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
    }
}
