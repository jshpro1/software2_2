/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.Stock.Cereal;
import Management.StockManagement.manager.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 남진우
 */
public class Bring_StockData {

    ArrayList al;

    public Bring_StockData(String type) {
        try {
            

//            String result = new BufferedReader(new FileReader(".\\playful_itmes.txt")).readLine();
//            it = new Gson().fromJson(result,Item.class);
//            System.out.println(result);
            Reader rd = null;

            if (type.equals("C")) {
                rd = new FileReader(".\\Cereal_Pcs.json");
            } else if (type.equals("M")) {
                rd = new FileReader(".\\Meat_Pcs.json");
            } else if (type.equals("V")) {
                rd = new FileReader(".\\Veggie_Pcs.json");
            } else if (type.equals("S")) {
                rd = new FileReader(".\\Sauce_Pcs.json");
            } else {
                System.out.println("잘못된 타입 입니다.");
            }

            al = (ArrayList<Cereal>)(new Gson().fromJson(rd, ArrayList.class));
            System.out.println(rd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList getList() {
        return al;
    }

}
