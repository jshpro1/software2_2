/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.PayManagement.payment.IngredientsProcess;
import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class SauceManager implements StockManager {

    private Menu menu;
    public ArrayList<Stock> slist;

    // Subject 하위 클래스들
    private IngredientsProcess op;
    private StockManagement smg;

    public SauceManager() {
        slist = new ArrayList<Stock>();
        bringData();
    }

    @Override
    public void subscribePaymentProcess(IngredientsProcess op) {

        op.addStockManager(this);
    }

    @Override
    public void subscribeStockMangement(StockManagement smg) {

        smg.addStockManager(this);
    }

    // 저장소에서 불러오기
    private void bringData() {
//        slist.stocks = new Bring_StockData(this.identify()).bringStocksList();
        slist = new Bring_StockData(this.identify()).slist;
    }

    @Override
    public String identify() { //정체성확인
        return "Sauce";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //업데이트들
    @Override
    public void updateMenuData(Menu menu) { //임시 
        this.menu = menu;
    }

    @Override
    public void updateStockData(ArrayList<Stock> slist) { //임시 
        this.slist = slist;
        saveData(slist);
    }

    private void saveData(ArrayList<Stock> slist) {
        new Save_StockDataDefalt(slist, this.identify());
    }

    @Override
    public ArrayList<Stock> getStocksList() {
        return slist;
    }

    @Override
    public void setStocksList(ArrayList<Stock> slist) {
        this.slist = slist;
    }
}
