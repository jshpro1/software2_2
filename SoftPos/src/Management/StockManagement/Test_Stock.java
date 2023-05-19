/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.*;
import Management.MenuManagement.Menu.PorkFriedRice;
import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import java.util.Scanner;

/**
 *
 * @author ³²Áø¿ì
 */
public class Test_Stock {

    public static void main(String[] args) {

//         model 0516
//        new StockManagement().makeStockData();
//        OrderProcess op = new OrderProcess();
//        CerealsManager cm = new CerealsManager(op);
//
//        PorkFriedRice pfr = new PorkFriedRice();
//        pfr.cook();
//        op.getMenu(pfr);
//        op.notifyStockManager();
        Stock st = new Cereal("»§",266,650);
        st.kind();
    }
}
