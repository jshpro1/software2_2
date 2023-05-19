/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import Management.StockManagement.Stock.*;
import java.util.ArrayList;

/**
 *
 * @author 남진우
 */
public class StockIsEmpty {

    public StockIsEmpty(ArrayList<Stock> stocks) {
        for (Stock stk : stocks) {
            if (stk.getPcs() == 0) {
                notifycation(stk);
            }
        }
    }
    public void notifycation(Stock stk) {
        System.out.println(stk.getName() + "의 재고가 비어있음");
        System.out.print("발주 신청을 하시겠습니까?");
    }
}
