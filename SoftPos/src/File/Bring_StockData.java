/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.*;
import Management.StockManagement.manager.*;
import Management.StockManagement.Stock.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
/**
 *
 * @author 남진우
 */
public class Bring_StockData implements Aggregate{

//    public StockList slist;
    public ArrayList<Stock> slist;

    public Bring_StockData(String type) {

        try {

            String result = null;
            StringBuilder sbuild = new StringBuilder();
//            Reader rd = null;

//            switch (sm.identify()) {
//                case "Staple":
//                    rd = new FileReader(".\\Staple_Pcs.json");
//                    break;
//                case "Meat":
//                    rd = new FileReader(".\\Meat_Pcs.json");
//                    break;
//                case "Veggie":
//                    rd = new FileReader(".\\Veggie_Pcs.json");
//                    break;
//                case "Sauce":
//                    rd = new FileReader(".\\Sauce_Pcs.json");
//                    break;
//                default:
//                    break;
//            }
            Type stockListType = null;
            switch (type) {
                case "Staple":
                    result = new BufferedReader(new FileReader(".\\Staple_Pcs.json")).readLine();
                    stockListType = new TypeToken<ArrayList<Staple>>() {
                    }.getType();
                    break;
                case "Meat":
                    result = new BufferedReader(new FileReader(".\\Meat_Pcs.json")).readLine();
                    stockListType = new TypeToken<ArrayList<Meat>>() {
                    }.getType();
                    break;
                case "Veggie":
                    result = new BufferedReader(new FileReader(".\\Veggie_Pcs.json")).readLine();
                    stockListType = new TypeToken<ArrayList<Veggie>>() {
                    }.getType();
                    break;
                case "Sauce":
                    result = new BufferedReader(new FileReader(".\\Sauce_Pcs.json")).readLine();
                    stockListType = new TypeToken<ArrayList<Sauce>>() {
                    }.getType();
                    break;
                default:
                    break;
            }

            sbuild.append(result);
//            slist = new StockList();
//            slist.stocks = new Gson().fromJson(result, stockListType);
            slist = new ArrayList<Stock>();
            slist = new Gson().fromJson(result, stockListType);
            /*
            0521 오류 수정
             */
//            System.out.println(((Stock)slist.stocks.get(0)).getPcs());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    StockListIterator 을 위한 메서드들
     */
    public int getLength() {
        return slist.size();
    }

    public Stock getStock(int index) {
        return slist.get(index);
    }

    @Override
    public Iterator createIterator() {
        return new StockListIterator(this);
    }

}
