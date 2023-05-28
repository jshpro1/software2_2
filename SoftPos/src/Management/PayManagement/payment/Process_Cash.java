/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import Management.PayManagement.receipt.*;
import File.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author 남진우
 */
public class Process_Cash { //리시버

    private Receipt receipt;

    public Process_Cash(Receipt receipt) {
        this.receipt = receipt;
    }
    
    public void CashReceiptProcessing(){
        ArrayList<Receipt> rlist;
        rlist = new Bring_ReceiptData().rlist;
        rlist.add(receipt);
        new Save_ReceiptData(rlist);
        System.out.println(receipt);
    }
}
