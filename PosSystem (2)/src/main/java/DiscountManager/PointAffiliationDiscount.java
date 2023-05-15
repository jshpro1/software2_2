/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
public class PointAffiliationDiscount implements Discount {
    private Discount discount;

    public PointAffiliationDiscount(double point) {
        this.discount = new AffiliationDiscount();
        this.discount = new PointDiscount(point);
    }

    @Override
    public double getDiscount(double price) {
        return discount.getDiscount(price);
    }
}
