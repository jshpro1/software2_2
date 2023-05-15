/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;

import Management.StockManagement.Stock.Basic.*;
import Management.StockManagement.Stock.Cereals.*;
import Management.StockManagement.Stock.Meats.*;
import Management.StockManagement.Stock.Sauce.*;
import Management.StockManagement.Stock.Veggies.*;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class PorkFriedRice extends Food{

    public PorkFriedRice() {
        material = new ArrayList<Stock>();
        
        material.add(new Rice());
        material.add(new Pork());
        material.add(new SoySauce());
        material.add(new Onion());
    }
    
    public void cook(){
    }
    
}
