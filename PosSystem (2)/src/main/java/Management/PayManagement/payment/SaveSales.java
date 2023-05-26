/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import File.Save_SalesData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;

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
    
    public void saveSalesData(){
        sale.date = new Date();
        sale.total = 0;
        
        slist.add(0,sale);
        
        // JSON으로 변환할 때 날짜 형식 지정
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
         
        new Save_SalesData(slist);
        
        String json = gson.toJson(slist);
        System.out.println(json);
        
        System.out.println("complete");
    }
}
