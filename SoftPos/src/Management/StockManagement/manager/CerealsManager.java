/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.Stock.*;
import Management.StockManagement.*;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class CerealsManager implements StockManager {

    private OrderProcess op;
    public Food menu;
    private ArrayList<Cereal> cereals;

    public CerealsManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);  // 재고 관리자 명단 구독

        bringData();
        
        cereals.get(0).kind();
        // 재고가 비었는지 확인하여 알림
//        new StockIsEmpty(cereals); 
    }

    // 저장소에서 불러오기
    private void bringData() {
        cereals =(ArrayList<Cereal>) new Bring_StockData("C").getList();
    }

 
    

    public Food getMenu() {
        return menu;
    }

    public void update(Food menu) { //임시 
        this.menu = menu;
    }

    public ArrayList<Cereal> getStockList() {
        return cereals;
    }

//    public void count(){ // 임시 재고 확인
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
