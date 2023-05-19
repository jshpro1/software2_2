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
 * @author 남진우
 */
public class Save_StockDataDefalt {

    public Save_StockDataDefalt(ArrayList defalt, String type) {
        try {
            File file = null;
            Gson gs = new Gson();
            
            if (type.equals("C")) {
                file = new File("Cereal_Pcs.json");
                defalt = (ArrayList<Cereal>)defalt;
            } else if (type.equals("M")) {
                file = new File("Meat_Pcs.json");
                defalt = (ArrayList<Meat>)defalt;
            } else if (type.equals("V")) {
                file = new File("Veggie_Pcs.json");
                defalt = (ArrayList<Veggie>)defalt;
            } else if (type.equals("S")) {
                file = new File("Sauce_Pcs.json");
                defalt = (ArrayList<Sauce>)defalt;
            } else {
                System.out.println("잘못된 타입 입니다.");
            }
            FileWriter writer = new FileWriter(file);

//            String fileWriter = gs.toJson(stockmanager.getStockList());
            String fileWriter = gs.toJson((ArrayList<Cereal>)defalt);
            System.out.println(fileWriter);

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
