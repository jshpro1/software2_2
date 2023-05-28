/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.update;

import File.Bring_MenuData;
import File.Bring_StockData;
import File.Save_MenuData;
import Management.MenuManagement.Menu.Menu;
import Management.StockManagement.Stock.Stock;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 남진우
 */
public class UpdateMenu { // 수정

//    public Menu enter_menu;
    public Menu updatemenu;
    public ArrayList<Menu> mlist;
    public ArrayList<Stock> stocks;
    private Vector vlist;
    public Vector<String> v;
    public Vector ingred;
    private String updatemenuname;

    public ArrayList<Vector> ingredients;

    public UpdateMenu() { //UpdateMenuName
        ingredients = new ArrayList<Vector>();
//        updatemenuname = umn;
        mlist = new Bring_MenuData().mlist;
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
이터레이터 삽입
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
    }

    public void setCategory(String category) {

        updatemenu.category = category;
    }

    public void ClearField() {
        v.clear();
        ingredients.clear();
        updatemenu = new Menu();
    }

    public void updateMenuData(String name) {

        updatemenu.ingredient = ingredients;
        String beforename = updatemenu.name;
        updatemenu.name = name;

        setPrice();
        setKcal();

        JOptionPane.showMessageDialog(null, beforename + "에서" + updatemenu.name + "으로 수정을 완료하였습니다");
        new Save_MenuData(mlist);

        ClearField();
        mlist = new Bring_MenuData().mlist;

    }

    public void setPrice() {
        updatemenu.price = 0;
        for (Vector vec : ingredients) {
            updatemenu.price += (int) vec.get(3) * 2;
        }
    }

    public void setKcal() {
        updatemenu.kcal = 0;
        for (Vector vec : ingredients) {
            updatemenu.kcal += (int) vec.get(2);
        }
    }

    public void getUpdateMenu(String umn) {

        for (Menu menu : mlist) {
            if (menu.name.equals(umn)) {
                updatemenu = menu;
            }
        }

    }
}
