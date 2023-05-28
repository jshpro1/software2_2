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
public class StaplesManager implements StockManager {

    // Subject 하위 클래스들
    private IngredientsProcess op;
    private StockManagement smg;

    public Menu menu;
//    public StocksList slist; // 저장할 재고 리스트 0522 잠시 잠금
    public ArrayList<Stock> slist;

    public StaplesManager() {

//        slist = new StocksList(this); 0522 잠시잠금
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
        slist = new Bring_StockData(this.identify()).slist;
    }

    @Override
    public String identify() { //정체성확인
        return "Staple";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //업데이트들
    @Override
    public void updateMenuData(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void updateStockData(ArrayList<Stock> slist) {
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
//    public void count(){ // 임시 재고 확인
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
