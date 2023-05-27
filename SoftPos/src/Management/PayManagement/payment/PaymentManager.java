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
import File.*;

public class PaymentManager {

    private Map<String, Command> commands = new HashMap<>();
    private ArrayList<Payment> payinfo;
    private Bring_ReceiptData br;
    
    public PaymentManager() {
        payinfo = new ArrayList<Payment>();
        
        commands.put("card", new CardPayCommand(payinfo));
        commands.put("cash", new CashPayCommand(payinfo));
        commands.put("mobile", new MobilePayCommand(payinfo));
        //commands.put("receipt", new ReceiptCommand(scanner));
    }

    public void GUIstart(String payType, Payment payment) {
        payinfo.add(payment);
        
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
