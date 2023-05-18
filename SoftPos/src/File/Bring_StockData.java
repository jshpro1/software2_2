/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.Stock.Cereal;
import Management.StockManagement.manager.*;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class Bring_StockData {
     ArrayList<Cereal> al;

    public Bring_StockData() {
        try {
            
//            String result = new BufferedReader(new FileReader(".\\playful_itmes.txt")).readLine();
//            it = new Gson().fromJson(result,Item.class);
//            System.out.println(result);

            Reader rd = new FileReader(".\\Stock_Pcs.json");
            al= new Gson().fromJson(rd, ArrayList.class);
            System.out.println(rd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList getList(){
        return al;
    }
    
}
