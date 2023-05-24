/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.update;

import File.*;
import Management.MenuManagement.Menu.Menu;
import Management.StockManagement.Stock.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 남진우
 */
public class MenuManager {

    private Vector vlist;
    private ArrayList<Menu> mlist;
    private DefaultTableModel tm;
    public MenuManager() {

    }

    public void setTable(String type, DefaultTableModel tm) {
        this.tm =tm;
        tm.setRowCount(0);
        mlist = new Bring_MenuData().mlist;

        for (Menu menu : mlist) {
            if (menu.category.equals(type)) {
                vlist = new Vector();
                vlist.add(menu.name);
                vlist.add(menu.kcal);
                vlist.add(menu.price);
                tm.addRow(vlist);
            }
        }
        tm.fireTableDataChanged();
    }

    public void deleteMenu(String deletemenu) {

        Menu deletedmenu = null;
        for (Menu menu : mlist) {
            if (menu.name.equals(deletemenu)) {
                deletedmenu = menu;
            }
        }
        JOptionPane.showMessageDialog(null, deletedmenu.name + "의 삭제를 완료하였습니다");
        mlist.remove(deletedmenu);
        new Save_MenuData(mlist);
    }
}
