/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.MenuManagement.Menu.*;
import Management.PayManagement.payment.IngredientsProcess;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public interface StockManager { //옵저버 인터페이스

    public void updateMenuData(Menu menu);
    public void updateStockData(ArrayList<Stock> slist);

    public void subscribePaymentProcess(IngredientsProcess op);

    public void subscribeStockMangement(StockManagement smg);

    public Menu getMenu();

    public String identify();

    public ArrayList<Stock> getStocksList();
    public void setStocksList(ArrayList<Stock> slist);

}
