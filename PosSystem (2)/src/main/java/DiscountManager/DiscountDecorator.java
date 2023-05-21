/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
//데코레이터 클래스 생성 
public abstract class DiscountDecorator implements Discount {

    private final Discount discount;

    public DiscountDecorator(Discount discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        if (discount != null) {
            return discount.applyDiscount(price);
        }
        return price;
    }
}
