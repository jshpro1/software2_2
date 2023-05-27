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
import Management.StockManagement.Stock.Meat;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class MeatsManager implements StockManager {

    private Menu menu;

    private ArrayList<Stock> slist;
//    public StockList slist;

    public MeatsManager() {

//        slist = new StockList();
        slist = new ArrayList<>();
//        bringData();
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
        return "Meat";
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

    private void saveData(ArrayList<Stock> slist){
        new Save_StockDataDefalt(slist,this.identify());
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
