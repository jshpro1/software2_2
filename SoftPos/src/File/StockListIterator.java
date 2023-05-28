/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.StockManagement.Stock.Stock;
import java.util.Iterator;

/**
 *
 * @author ³²Áø¿ì
 */
public class StockListIterator implements Iterator<Stock> {

    private Bring_StockData bring_sd;
    private int index = 0;

    public StockListIterator(Bring_StockData bring_sd) {
        this.bring_sd = bring_sd;
    }

    @Override
    public boolean hasNext() {
        return index < bring_sd.getLength();
    }
    
    @Override
    public Stock next(){
        Stock stock = bring_sd.getStock(index);
        index ++;
        return stock;
    }
}
