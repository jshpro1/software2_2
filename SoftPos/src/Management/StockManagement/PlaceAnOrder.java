/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.*;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ( ! ) 수정 필요한 코드
 * @author 남진우
 */
public class PlaceAnOrder { 

    private ArrayList<Stock> paolist;

    public PlaceAnOrder() {

    }

    /*
    
     */
    public void paoRequest() { // 발주 요청

        Scanner scn = new Scanner(System.in);
        int st = 0; // StocksType : 발주할 물품 타입을 선택하기 위한 입력
        int ss = 0; // SelectedStock : 선택할 물품 번호 입력

        // 발주할품목
        // 선택하는 코드
        System.out.println("발주할 품목 선택");
        System.out.println("1 : Staple");
        System.out.println("2 : Meat");
        System.out.println("3 : Veggie");
        System.out.println("4 : Sauce");
        System.out.print("입력 : ");
        st = scn.nextInt(); // StocksType : 발주할 물품 타입을 선택하기 위한 입력

        paolist = selectStocksType(st);

        /*
        선택된 품목 
        보여주는 코드
        */
        int num = 1;
        System.out.println("발주할 재고 선택");
        for (Stock stk : paolist) {
            System.out.println("");
            System.out.println("---" + num + "번물품---");
            System.out.println("제품 : " + stk.getName());
            System.out.println("칼로리 : " + stk.getKcal());
            System.out.println("단가 : " + stk.getPrice());
            System.out.println("수량 : " + stk.getPcs());
            System.out.println("------------");
            num++;
        }
        System.out.print("입력 : ");
        ss = scn.nextInt()-1;// SelectedStock : 선택할 물품 번호 입력

        // 재고 입력된 수량만큼
        // 발주하는 코드 ( ! ) 수정필요
        int pp = paolist.get(ss).getPcs(); // PlaceanorderPieces : 발주할 수량 입력
        System.out.print("발주할 재고 수량을 입력하시오 : ");
        pp = scn.nextInt();
        
        System.out.println(paolist.get(ss).getPcs());
        
    }



    //발주할 물품 타입 고르는 코드 ( ! ) 수정필요
    private ArrayList<Stock> selectStocksType(int type) {
        switch (type) {
            case 1:
                return new Bring_StockData("Staple").bringStocksList();
            case 2:
                return new Bring_StockData("Meat").bringStocksList();
            case 3:
                return new Bring_StockData("Veggie").bringStocksList();
            case 4:
                return new Bring_StockData("Sauce").bringStocksList();
            default:
                break;
        }
        return null;
    }
    //발주할 물품 고르는 코드 ( ! ) 수정필요

    private Stock selectStock(int type) {
        for (Stock stk : paolist) {
            if (stk.getName().equals(type)) {
                return stk;
            }
        }
        return null;
    }

    
    
    
    
    
    // 재고 현황
    // 보여주기
    public void viewStockState(ArrayList<Stock> slist) {
        for (Stock stk : slist) {
            System.out.println(stk.getName() + "의 재고 수 : " + stk.getPcs());
        }
    }
}





