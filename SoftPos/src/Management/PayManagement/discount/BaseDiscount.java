/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.discount;

/**
 *
 * @author jsh
 */
//???? ???? ???? ?´ë????
public class BaseDiscount implements Discount {

    private int price;

    public BaseDiscount(int price) {
        this.price = price;
    }
    
    
    @Override
    public int applyDiscount() {
        return price;
    }
}
