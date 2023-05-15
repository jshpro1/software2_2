/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.Test.Json;

import Management.StockManagement.Stock.Basic.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author 남진우
 */
public class StockToJson { // 임마도 임시 방편

    public StockToJson(Stock stock) {
        try{
            Gson gs = new Gson();
            File file = new File("Stocks.json");
            FileWriter writer = new FileWriter(file);
        
            
            String fileWriter = gs.toJson(stock);

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
