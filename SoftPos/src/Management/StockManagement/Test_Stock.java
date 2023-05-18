/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import Management.MenuManagement.Menu.PorkFriedRice;
import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.manager.CerealsManager;

/**
 *
 * @author ³²Áø¿ì
 */
public class Test_Stock {
    public static void main(String[] args) {
        
        // model 0516
        OrderProcess op = new OrderProcess();
        CerealsManager cm = new CerealsManager(op);
        
        op.getMenu(new PorkFriedRice());
        op.notifyStockManager();
        cm.count();
        
    }
}
