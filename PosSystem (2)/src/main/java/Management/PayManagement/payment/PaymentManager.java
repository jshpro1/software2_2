/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

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
        commands.put("card", new CardPayCommand());
        commands.put("cash", new CashPayCommand());
        commands.put("mobile", new MobilePayCommand());
        //commands.put("receipt", new ReceiptCommand(scanner));
    }

    public void GUIstart(String payType) {
        Command command = commands.get(payType);
        if (command != null) {
            command.execute();
        } else if (payType.equals("quit")) {
            System.out.println("시스템을 종료합니다.");
            System.exit(0);
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택하세요.");
        }
    }
}
