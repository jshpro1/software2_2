/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import Management.MenuManagement.Menu.Beverage;
import Management.MenuManagement.Menu.Meat_Menu;
import Management.MenuManagement.Menu.RiceAndNoodle;
import Management.MenuManagement.Menu.Salad;
import Management.MenuManagement.Menu.SideDish;
import Management.MenuManagement.Menu.Various_Menu;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class Order_Menu {
    private Various_Menu various_menu;

    public Order_Menu(Various_Menu vm) {
        various_menu = vm;
    }
    
    // 주문관리 시스템 메뉴 카테고리별 처리
    public ArrayList<RiceAndNoodle> getRiceAndNoodle(){ // 밥,&면 카테고리
        return various_menu.riceAndnoodles;
    }
    
    public ArrayList<Meat_Menu> getMeats(){ // 고기 카테고리
        return various_menu.meats;
    }
    
    public ArrayList<Salad> getSalads(){ // 셀러드 카테고리
        return various_menu.salads;
    }
    
    public ArrayList<SideDish> getSides(){ // 사이드 카테고리
        return various_menu.sides;
    }
    
    public ArrayList<Beverage> getBeverages(){ // 음료 카테고리
        return various_menu.beverages;
    }
}
