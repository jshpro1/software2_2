/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.manager.*;

/**
 *
 * @author 남진우
 */
public class PlaceAnOrder {
    
    private CerealsManager cerealsmanager;
    private MeatsManager meatsmanager;
    private SauceManager saucemanager;
    private VeggiesManager veggieManager;

    public PlaceAnOrder() {
        OrderProcess op = new OrderProcess(); // 임시 주문 처리
        cerealsmanager = new CerealsManager(op);
        meatsmanager = new MeatsManager(op);
        saucemanager = new SauceManager(op);
        veggieManager = new VeggiesManager(op);
        
    }
    
    
}
