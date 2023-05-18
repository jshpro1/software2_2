/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.Stock.*;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.manager.StockManager;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class Save_StockDataDefalt {

    public Save_StockDataDefalt(ArrayList<Cereal> defalt) {
        try{
            Gson gs = new Gson();
            File file = new File("Stock_Pcs.json");
            FileWriter writer = new FileWriter(file);
        
            
//            String fileWriter = gs.toJson(stockmanager.getStockList());
            String fileWriter = gs.toJson(defalt);
            System.out.println(fileWriter);

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
