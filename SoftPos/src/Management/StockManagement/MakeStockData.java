/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.Save_StockDataDefalt;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import java.util.Scanner;

/**
 *
 * @author 남진우
 */
public class MakeStockData { // 제일처음 재고 파일 생성용 별로 안중요
    
    public MakeStockData(StockManager sm) {

        Scanner scn = new Scanner(System.in);

        System.out.println(sm.identify()+"재고 삽입");

        boolean plag = true;
        while (plag) {

            System.out.print("재고의 이름을 입력 : ");
            String name = scn.next();

            System.out.print("재고의 칼로리를 입력 : ");
            int kcal = scn.nextInt();

            System.out.print("재고의 단가를 입력 : ");
            int unit_price = scn.nextInt();

           
                    
            switch (sm.identify()) {
                case "Staple":
                    sm.getStocksList().add(new Staple(name,kcal,unit_price));
                    break;
                case "Meat":
                    sm.getStocksList().add(new Meat(name, kcal, unit_price));
                    break;
                case "Veggie":
                    sm.getStocksList().add(new Veggie(name, kcal, unit_price));
                    break;
                case "Sauce":
                    sm.getStocksList().add(new Sauce(name, kcal, unit_price));
                    break;
            }
            
            System.out.print("계속 입력 하시겠습니까? ( 1: Y / 2: N ) : ");
            String check = scn.next();

            if (check.equals("1")); else {
                plag = false;
            }
        }
        new Save_StockDataDefalt(sm.getStocksList(),sm.identify());
    }
}
 