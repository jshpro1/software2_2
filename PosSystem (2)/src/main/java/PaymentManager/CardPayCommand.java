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
    double price;
    
    public CardPayCommand(double price) {
        this.price = price;
    }
    
    public void execute(){
        pay.CardPay(price);
    }
}
