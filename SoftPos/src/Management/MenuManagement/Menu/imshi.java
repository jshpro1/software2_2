/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;

import Management.StockManagement.Stock.Veggie;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class imshi extends Food{

    public imshi() {
        main_stock = new ArrayList<Veggie>();
    }
    public void carr(){
        main_stock.add(new Veggie("Onion",20,200));
    }

    
    public void cook() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
