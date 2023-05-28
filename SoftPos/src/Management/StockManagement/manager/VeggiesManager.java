/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.PayManagement.payment.PaymentProcess;
import File.Bring_StockData;
import File.Save_StockDataDefalt;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class VeggiesManager implements StockManager {

    // Subject 하위 클래스들
    private PaymentProcess op;
    private StockManagement smg;

    private Menu menu;
    public ArrayList<Stock> slist;

    public VeggiesManager() {
        slist = new ArrayList<Stock>();

        bringData();

        // 재고가 비었는지 확인하여 알림
//        new StockIsEmpty(cereals); 
    }

    @Override
    public void subscribePaymentProcess(PaymentProcess op) {

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
        return "Veggie";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //업데이트들
    @Override
    public void updateMenuData(Menu menu) { //임시 
        this.menu = menu;
        saveData(slist);
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
