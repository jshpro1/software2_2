/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import File.*;
import Management.MenuManagement.Menu.*;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ³²Áø¿ì
 */
public class Order {

    public ArrayList<Menu> mlist;
    public Vector<Vector> orderlist;
    public Vector orderinfo;
    public Vector<Menu> vlist;
    public ArrayList<JButton> btnlist;
    public OrderCarculator ocal;

    public Order() {
        orderlist = new Vector<Vector>();
    }
//        System.out.println(new Gson().toJson(mlist));

    public void setMenus(String ctype) {
        mlist = new Bring_MenuData().mlist;
        int i = 0;
        setEnableF();
        setTextNull();
        for (Menu m : mlist) {
            if (m.category.equals(ctype)) {

                btnlist.get(i).setText(m.name);
                btnlist.get(i).setEnabled(true);

                i++;
            }
        }
    }

    public void getbtnList(ArrayList<JButton> btnlist) {
        this.btnlist = btnlist;
    }

    public void setEnableF() {
        for (JButton jbtn : btnlist) {
            jbtn.setEnabled(false);
        }
    }

    public void setTextNull() {
        for (JButton jbtn : btnlist) {
            jbtn.setText("");
        }
    }

    public void addOrder(String mname, DefaultTableModel tm) {

        setOrderinfo();

        boolean dup = false;
        tm.setRowCount(0);

        for (Vector vec : orderlist) {
            if (vec.get(1).equals(mname)) {
                dup = true;
                vec.set(3, (int) vec.get(3) + 1);
                vec.set(5, (int) vec.get(3) * (int) vec.get(2));
            }
            tm.addRow(vec);
        }
        if (!dup) {
            for (Menu m : mlist) {
                if (m.name.equals(mname)) {
                    orderlist.add(orderinfo);
                    orderinfo.set(0, orderlist.indexOf(orderinfo) + 1);
                    orderinfo.set(1, m.name);
                    orderinfo.set(2, m.price);
                    orderinfo.set(3, 1);
                    orderinfo.set(4, 0);
                    orderinfo.set(5, (int) orderinfo.get(3) * (int) orderinfo.get(2));
                    tm.addRow(orderinfo);
                }
            }
        }

        tm.fireTableDataChanged();
    }
    public void setAmounts(DefaultTableModel atm, int ra){
        
        ocal = new OrderCarculator(orderlist);
        ocal.setAmounts(atm, ra);
    }

    public void setOrderinfo() {
        orderinfo = new Vector();
        orderinfo.add(0);
        orderinfo.add("");
        orderinfo.add(0);
        orderinfo.add(0);
        orderinfo.add(0);
        orderinfo.add(0);
    }
}
