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

public class ReceiptCommand implements Command{
    private Payment pay = new Payment();
    private Scanner scanner;
    
    public ReceiptCommand(Scanner scanner) {
        this.scanner = scanner;
    }
    public void execute(){
        pay.showReceipt(scanner);
    }
}
