/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.update;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.StockManagement.Stock.*;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author 남진우
 */
public class AddMenu {

    public Menu enter_menu;
//    public Menu menu;
    public ArrayList<Menu> mlist;
    public ArrayList<Stock> stocks;
    private Vector vlist;
    public Vector<String> v;
    public Vector ingred;
//    private Bring_StockData bsd;
//    private Bring_MenuData bmd;

    public ArrayList<Vector> ingredients;

    public AddMenu() {

        ingredients = new ArrayList<Vector>();
        mlist = new ArrayList<Menu>();
        mlist = new Bring_MenuData().mlist;
        System.out.println(new Gson().toJson(mlist));
        enter_menu = new Menu();
    }

    public void setTable(String type, DefaultTableModel tm) {
        tm.setRowCount(0);
        //        stocks = new Bring_StockData(type).slist;
//        for (int i = 0; i < stocks.size(); i++) {
//            vlist = new Vector();
//            vlist.add(stocks.get(i).getName());
//            vlist.add(stocks.get(i).getKcal());
//            vlist.add(stocks.get(i).getPrice());
//            tm.addRow(vlist);
//        }
        /*
        0528 이터레이터 삽입
         */
        Iterator slist_it = new Bring_StockData(type).createIterator();
        while (slist_it.hasNext()) {
            Stock stk = (Stock) slist_it.next();
            vlist = new Vector();
            vlist.add(stk.getName());
            vlist.add((int) stk.getKcal());
            vlist.add(stk.getPrice());
        }
        tm.fireTableDataChanged();
    }

    public void setIngredients(int index) {

        ingred = new Vector();
        ingred.add(stocks.get(index).getName());
        ingred.add(stocks.get(index).kind());
        ingred.add(stocks.get(index).getKcal());
        ingred.add(stocks.get(index).getPrice());
        ingredients.add(ingred);
        v = new Vector<String>();
        for (Vector vec : ingredients) {
            v.add((String) vec.get(0));
        }

//        switch (stocks.get(index).kind()) {
//            case "Staple":
//                enter_menu.staples.add((Staple) stocks.get(index));
//                v.add(stocks.get(index).getName());
//                break;
//            case "Meat":
//                enter_menu.meats.add((Meat) stocks.get(index));
//                v.add(stocks.get(index).getName());
//                break;
//            case "Sauce":
//                enter_menu.sauces.add((Sauce) stocks.get(index));
//                v.add(stocks.get(index).getName());
//                break;
//            case "Veggie":
//                enter_menu.veggies.add((Veggie) stocks.get(index));
//                v.add(stocks.get(index).getName());
//                break;
//        }
    }

    public void setCategory(String category) {

        enter_menu.category = category;
    }

    public void ClearField() {
        v.clear();
        ingredients.clear();
        enter_menu = new Menu();
    }

    public void insertMenuData(String name) {

        enter_menu.ingredient = ingredients;
        enter_menu.name = name;
        mlist.add(0, enter_menu);

        setPrice();
        setKcal();

        JOptionPane.showMessageDialog(null, mlist.get(0).name + "의 등록을 완료하였습니다");
        new Save_MenuData(mlist);

        ClearField();
        mlist = new Bring_MenuData().mlist;

    }

    public void setPrice() {
        enter_menu.price = 0;
        for (Vector vec : ingredients) {
            enter_menu.price += (int) vec.get(3) * 2;
        }
    }

    public void setKcal() {
        enter_menu.kcal = 0;
        for (Vector vec : ingredients) {
            enter_menu.kcal += (int) vec.get(2);
        }
    }

}
