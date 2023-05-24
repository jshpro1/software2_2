/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.manager.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author ³²Áø¿ì
 */
public class Save_StockData {

    public Save_StockData(StockManager sm) {
        try{
            Gson gs = new Gson();
            File file = new File("Stock_Pcs.json");
            FileWriter writer = new FileWriter(file);
        
            
//            String fileWriter = gs.toJson(stockmanager.getStockList());
            String fileWriter = gs.toJson(sm.getStocksList());

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
