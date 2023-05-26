/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import UI.OrderManagement_UI.Order_UI;
import java.util.*;
/**
 *
 * @author USER
 */
public class Payment {
    public String method;
    public Date date;
    public ArrayList<Vector> list;
    public double tax;
    public double surtax;
    public double sum;
    public int discount;
    public double total;
    
    public SaveReceipt save;
    
    public Payment() {
        method = "";
        date = new Date();
        list = new ArrayList<Vector>();
        tax = 0;
        surtax = 0;
        sum = 0;
        discount = 0;
        total = 0;
    }
    
    public void CardPay(){
        SaveReceipt save = new SaveReceipt();
        save.saveReceiptData("카드 결제");
    }
    
    public void CashPay(){
        
    }
    
    public void MobilePay(){
        
    }
    
    public static void main(String[] args) {
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_UI().setVisible(true);
            }
        });
*/
        PaymentManager start = new PaymentManager();
        start.GUIstart("card");
        
        SaveSales save2 = new SaveSales();
        save2.saveSalesData();
    }
    
}
