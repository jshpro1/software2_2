/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
public class TelecomAffiliationDiscount implements Discount {
    private Discount discount;

    public TelecomAffiliationDiscount() {
        this.discount = new AffiliationDiscount();
        this.discount = new TelecomDiscount(this.discount);
    }

    @Override
    public double getDiscount(double price) {
        return discount.getDiscount(price);
    }
}
