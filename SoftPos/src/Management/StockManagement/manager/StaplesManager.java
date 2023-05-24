/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;

/**
 *
 * @author 남진우
 */
public class StaplesManager implements StockManager {

    private OrderProcess op;
    public Menu menu;
//    public StocksList slist; // 저장할 재고 리스트 0522 잠시 잠금
    public StockList slist;

    public StaplesManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);  // 재고 관리자 명단 구독

//        slist = new StocksList(this); 0522 잠시잠금
        slist = new StockList();

        bringData();

    }

    // 저장소에서 불러오기
    private void bringData() {
        new Bring_StockData(this.identify());
    }

    @Override
    public String identify() { //정체성확인
        return "Staple";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void update(Menu menu) { //임시 
        this.menu = menu;
    }

    @Override
    public StockList getStocksList() {
        return slist;
    }
//    public void count(){ // 임시 재고 확인
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
