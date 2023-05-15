/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */

//포인트 할인
public class PointDiscount extends DiscountDecorator {
    private final double point;

    public PointDiscount(Discount discount, double point) {
        super(discount);
        this.point = point;
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price - point);
    }
}
