/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

/**
 *
 * @author USER
 */
public class MobilePayCommand implements Command{
    private Payment pay = new Payment();

    public MobilePayCommand() {
    }
    
    public void execute(){
        pay.MobilePay();
    }
}
