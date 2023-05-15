/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */

//통신사 할인 5%
public class TelecomDiscount extends DiscountDecorator {
    

    public TelecomDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price * 0.95);
    }
}

