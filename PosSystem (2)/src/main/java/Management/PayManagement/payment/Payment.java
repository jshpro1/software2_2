/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import File.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class Payment {
    public String name;
    public String date;
    public int price;
    public int salesamount;
    public double totalsalesamount;
    public ArrayList<Vector> vector;
    
    public Payment() {
        name = "name";
        price = 0;
        salesamount = 0;
        totalsalesamount = 0;
        date = "";
    }
    public static void main(String[] args) {
        SavePayment save = new SavePayment();
        
        save.insertPaymentData("name");
    }
}
