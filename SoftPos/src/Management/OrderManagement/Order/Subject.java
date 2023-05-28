/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Management.OrderManagement.Order;

import Management.StockManagement.manager.StockManager;

/**
 *
 * @author ³²Áø¿ì
 */
public interface Subject {

    public void addStockManager(StockManager o);

    public void removeStockManager(StockManager o);

    public void notifyStockManager();
}
