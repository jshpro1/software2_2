/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import java.util.*;
import File.*;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */

public class SavePayment {
    public ArrayList<Payment> mlist;
    public Payment enter_pay;
    public ArrayList<Vector> vectors;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public SavePayment(){
        mlist = new ArrayList<Payment>();
        enter_pay = new Payment();
        vectors = new ArrayList<Vector>();
    }
    
    public void insertPaymentData(String name) {
        enter_pay.vector = vectors;
        enter_pay.name = name;
        enter_pay.date = dateFormat.format(new Date());
        mlist.add(0,enter_pay);
        
        setTotalPrice();
        
        new Save_PaymentData(mlist);
        System.out.println(new Gson().toJson(mlist));
        System.out.println("complete");
    }
    
    
    
    public void setTotalPrice() {
        enter_pay.price = 100;
        for (Vector vec : vectors) {
            enter_pay.totalsalesamount += (int) vec.get(3)*2;
        }
    }
}
