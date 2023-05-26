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
 * @author 남진우
 */
public class Save_StockDataDefalt {

    public Save_StockDataDefalt(StockList slist,String type) {
        try {
            File file = null;
            Gson gs = new Gson();
            
            if (type.equals("Staple")) {
                file = new File("Staple_Pcs.json");
            } else if (type.equals("Meat")) {
                file = new File("Meat_Pcs.json");
            } else if (type.equals("Veggie")) {
                file = new File("Veggie_Pcs.json");
            } else if (type.equals("Sauce")) {
                file = new File("Sauce_Pcs.json");
            } else {
                System.out.println("잘못된 타입 입니다.");
            }
            FileWriter writer = new FileWriter(file);

            String fileWriter = gs.toJson(slist.stocks);
            System.out.println(fileWriter);

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
