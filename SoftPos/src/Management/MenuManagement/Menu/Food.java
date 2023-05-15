/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;


import Management.StockManagement.Stock.Basic.*;
import java.util.ArrayList;


/**
 * 5/ 16 메뉴 상위 클래스
 * @author 남진우
 */


public abstract class Food { //메뉴

    public String name;
    public int price;
    public ArrayList<Stock> material;
    
    public abstract void cook();
    
}
   