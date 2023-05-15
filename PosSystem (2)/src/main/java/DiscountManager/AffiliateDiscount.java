/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */

//제휴할인 3%
public class AffiliateDiscount extends DiscountDecorator {
    

    public AffiliateDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price * 0.97);
    }
}
