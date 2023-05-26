/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.StockManagement.Stock.*;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
/*
0522 이후 비활성화
*/
public class StocksList {

    private ArrayList<Staple> staples;
    private ArrayList<Meat> meats;
    private ArrayList<Veggie> veggies;
    private ArrayList<Sauce> sauces;

    public StocksList(StockManager sm) {

        switch (sm.identify()) {
            case "Staple":
                staples = new ArrayList<Staple>();
                break;
            case "Meat":
                meats = new ArrayList<Meat>();
            case "Veggie":
                veggies = new ArrayList<Veggie>();
                break;
            case "Sauce":
                sauces = new ArrayList<Sauce>();
                break;
            default:
                break;
        }
    }

    public ArrayList<Staple> getList(StockManager sm) {

//        switch (sm.identify()) {
//            case "Staple":
//                return staples;
//            case "Meat":
//                return meats;
//            case "Veggie":
//                return veggies;
//            case "Sauce":
//                return sauces;
//            default:
//                break;
//        }
        return staples;
    }

}
