/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.MenuManagement.Menu.Menu;
import Management.OrderManagement.Order.Subject;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.manager.*;

import java.util.*;

/**
 * 5/ 16 재고 처리 관련 기능 구현
 *
 * @author 남진우
 */
public class IngredientsProcess implements Subject { // 일단 재고 처리 관련 기능

    private ArrayList<StockManager> stockmanagers; //재고 관리자 명단
//    public Menu menu; // 처리할 메뉴
    public ArrayList<Menu> mlist; // 메뉴 리스트
    public Vector<Object[]> menu_pcs; // 메뉴랑 해당 매뉴 수량
    public Vector<String> stocknamelist; // 스톡 이름 리스트

    public IngredientsProcess() { // 명단 생성
        menu_pcs = new Vector<Object[]>(); //초기화
        stockmanagers = new ArrayList<StockManager>(); //초기화

        new StaplesManager().subscribePaymentProcess(this);
        new MeatsManager().subscribePaymentProcess(this);
        new SauceManager().subscribePaymentProcess(this);
        new VeggiesManager().subscribePaymentProcess(this);

        bringStockData();
    }

    public void addStockManager(StockManager o) { // 명단에 관리자 추가

        stockmanagers.add(o);
    }

    public void removeStockManager(StockManager o) {  // 명단에서 삭제
        stockmanagers.remove(o);
    }

    public void notifyStockManager() { // 구독자들한테 알림
        for (StockManager sm : stockmanagers) {  // 모든 관리자 돌면서 실행
            sm.updateStockData(sm.getStocksList());
        }
    }

    public void bringStockData() {
        for (StockManager sm : stockmanagers) {
            sm.setStocksList(new Bring_StockData(sm.identify()).slist);
        }
    }

//    public void getMenu(Menu menu) { // 임시 메뉴 입력 받기
//        this.menu = menu;
//    }

    /*
    메뉴랑 해당 메뉴 수량
    menu_pcs 에 정리하는 코드
     */
    public void checkUsedStock(Vector<Vector> orderlist) {
        for (Vector vec : orderlist) {
            Object[] mp = {"", 0}; //메뉴와 해당매뉴 수량 갖는 객체
            mp[0] = vec.get(1); // 메뉴 명
            mp[1] = vec.get(3); // 해당메뉴 수량
            menu_pcs.add(mp);
        }
    }

    /*
    
     */
    public void applyUsedStock() {
        mlist = new Bring_MenuData().mlist;

        for (Menu menu : mlist) {
            for (Object[] obj : menu_pcs) {
                if(menu.name.equals(String.valueOf(obj[0]))){
                    for(Vector vec : menu.ingredient){
                        StockManager sm = null;
                        switch((String)vec.get(1)){ // 재료의 카테고리가 아래 타입이면
                            case "Staple":
                                sm = stockmanagers.get(0);
                                break;
                            case "Meat":
                                sm = stockmanagers.get(1);
                                break;
                            case "Sauce":
                                sm = stockmanagers.get(2);
                                break;
                            case "Veggie":
                                sm = stockmanagers.get(3);
                                break;
                        }
                        for(Stock stk : sm.getStocksList()){
                            if(stk.getName().equals((vec.get(0).toString()))){
                                stk.setPcs(stk.getPcs()-(int)obj[1]);
                            }
                        }
                    }
                }
            }
        }
//        for (StockManager sm : stockmanagers) {
//            for (Stock stk : sm.getStocksList()) {
////                if (stk.getName().equals(sname)) {
////                    stk.setPcs(pcs + stk.getPcs());
////                    System.out.println(stk.kind());
//            }
//        }
    }
}
