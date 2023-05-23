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

public class CardPayCommand implements Command{
    private Payment pay = new Payment();
    private Map<Integer, String[]> payinfo;
    private Scanner scanner;

    public CardPayCommand(Map<Integer, String[]> payinfo, Scanner scanner) {
        this.payinfo = payinfo;
        this.scanner = scanner;
    }
    
    public void execute(){
        pay.CardPay(payinfo, scanner);
    }
}
