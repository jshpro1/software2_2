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
 *
 * @author 남진우
 */
public class StockManagement {

    public StockManagement() {
    }

    public void makeStockData() {

        ArrayList stocks = new ArrayList();
        Scanner scn = new Scanner(System.in);
        
        System.out.println("무슨 타입의 재고를 입력하시겠습니까?");
        System.out.println("C : Cereal");
        System.out.println("M : Meat");
        System.out.println("V : Veggie");
        System.out.println("S : Sauce");
        System.out.print("입력 : ");
        String type = scn.next();
        
        boolean plag = true;
        while (plag) {

            System.out.print("재고의 이름을 입력 : ");
            String name = scn.next();

            System.out.print("재고의 칼로리를 입력 : ");
            int kcal = scn.nextInt();

            System.out.print("재고의 단가를 입력 : ");
            int unit_price = scn.nextInt();

            if (type.equals("C")) {
                stocks.add(new Cereal(name, kcal, unit_price));
            }else if (type.equals("M")){
                stocks.add(new Meat(name, kcal, unit_price));
            }else if( type.equals("V")){
                stocks.add(new Veggie(name, kcal, unit_price));
            }else if(type.equals("S")){
                stocks.add(new Sauce(name,kcal,unit_price));
            }else System.out.println("잘못된 타입 입니다.");

            System.out.print("계속 입력 하시겠습니까? (Y/N) : ");
            String check = scn.next();

            if (check.equals("Y")); else {
                plag = false;
            }

        }

        System.out.println(stocks);

        new Save_StockDataDefalt(stocks,type);

    }

}
