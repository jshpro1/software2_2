/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.MenuManagement.Menu.*;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public interface StockManager {
    
    public void update(Menu menu);
    public Menu getMenu();
    public String identify();
    public StockList getStocksList();
    
    
}
