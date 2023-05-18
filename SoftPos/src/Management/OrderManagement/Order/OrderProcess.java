/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import Management.MenuManagement.Menu.Food;
import Management.StockManagement.manager.StockManager;


import java.util.ArrayList;

/**
 * 5/ 16 재고 처리 관련 기능 구현
 * @author 남진우
 */
public class OrderProcess implements Subject{ // 일단 재고 처리 관련 기능
    
    private ArrayList<StockManager> stockmanagers; //재고 관리자 명단
    public Food menu ; // 처리할 메뉴

    public OrderProcess() { // 명단 생성
        stockmanagers = new ArrayList<StockManager>();
    }
    
    public void addStockManager(StockManager o) { // 명단에 관리자 추가
        
        stockmanagers.add(o);
    }

    public void removeStockManager(StockManager o) {  // 명단에서 삭제
        stockmanagers.remove(o); 
    }

    public void notifyStockManager() { // 구독자들한테 알림
        for(StockManager all_sm : stockmanagers){  // 모든 관리자 돌면서 실행
            all_sm.update(menu);
        }
    }
    public void getMenu(Food menu){ // 임시 메뉴 입력 받기
        this.menu = menu;
    }
    
}
