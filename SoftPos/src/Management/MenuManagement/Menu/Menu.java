/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;

import Management.StockManagement.Stock.*;
import java.util.*;

/**
 *
 * @author ³²Áø¿ì
 */
public class Menu {
    public String name;
    public int price;
    public int kcal;
    public ArrayList<Vector> ingredient;
    public String category;

    public Menu() {
        name = "";
        price = 0;
        kcal =0 ;
        category = "";
        ingredient = new ArrayList<Vector>();
    }
    
}
