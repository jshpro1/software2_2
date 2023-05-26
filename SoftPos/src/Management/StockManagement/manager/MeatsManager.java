/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.Bring_StockData;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;

/**
 *
 * @author 남진우
 */
public class MeatsManager implements StockManager{
    private OrderProcess op;
    private Menu menu;
    
    public StockList slist;
    public MeatsManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);
        
        slist = new StockList();
        bringData();
    }
    
        // 저장소에서 불러오기
    private void bringData() {
//        slist.stocks = new Bring_StockData(this.identify()).bringStocksList();
        new Bring_StockData(this.identify());
    }

    @Override
    public String identify() { //정체성확인
        return "Meat";
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
}
