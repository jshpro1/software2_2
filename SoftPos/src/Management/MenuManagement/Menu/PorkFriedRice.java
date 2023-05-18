/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;

import Management.StockManagement.Stock.Cereal;
import Management.StockManagement.Stock.Meat;
import Management.StockManagement.Stock.Sauce;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.Stock.Veggie;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class PorkFriedRice extends Food{

    public PorkFriedRice() {
        material = new ArrayList<Stock>();
        
        material.add(new Cereal());
        material.add(new Meat());
        material.add(new Sauce());
        material.add(new Veggie());
    }
    
    public void cook(){
    }
    
}
