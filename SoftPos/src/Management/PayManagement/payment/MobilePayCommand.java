/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class MobilePayCommand implements Command{
    private Payment pay = new Payment();
    ArrayList<Payment> payinfo;

    public MobilePayCommand(ArrayList<Payment> payinfo) {
        this.payinfo = payinfo;
    }
    
    public void execute(){
        pay.MobilePay(payinfo);
    }
}
