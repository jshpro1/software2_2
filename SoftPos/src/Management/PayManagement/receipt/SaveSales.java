/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.receipt;

import File.*;
import Management.PayManagement.payment.*;
import com.google.gson.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class SaveSales {
    public ArrayList<Sales> slist;
    public Sales sale;
    
    public SaveSales(){
        slist = new ArrayList<Sales>();
        sale = new Sales();
    }
    
    public void saveSalesData(int price){
        sale.date = new Date();
        sale.total = price;
        
        slist.add(0,sale);
        
        // JSON으로 변환할 때 날짜 형식 지정
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
         
        new Save_SalesData(slist);
        
        String json = gson.toJson(slist);
        System.out.println(json);
        
        System.out.println("complete");
    }
}
