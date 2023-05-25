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

public class CashPayCommand implements Command{
    private Payment pay = new Payment();
    
    public CashPayCommand() {
    }
    
    public void execute(){
        pay.CashPay();
    }
}
