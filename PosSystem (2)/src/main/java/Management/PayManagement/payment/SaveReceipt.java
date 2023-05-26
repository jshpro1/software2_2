/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import java.util.*;
import File.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

/**
 *
 * @author USER
 */

public class SaveReceipt {
    public ArrayList<Payment> rlist;
    public Payment pay;
    public ArrayList<Vector> lists;
    
    public SaveReceipt(){
        rlist = new ArrayList<Payment>();
        pay = new Payment();
        lists = new ArrayList<Vector>();
    }
    
    public void saveReceiptData(String method) {
        pay.method = method;
        pay.date = new Date();
        pay.list = lists;
        pay.tax = 91;
        pay.surtax = 909;
        pay.sum = pay.tax + pay.surtax;
        pay.discount = 500;
        pay.total = pay.sum - pay.discount;
        
        rlist.add(0,pay);
        
        // JSON으로 변환할 때 날짜 형식 지정
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        
        new Save_ReceiptData(rlist);
        
        String json = gson.toJson(rlist);
        System.out.println(json);
        
        System.out.println("complete");
    }
}
