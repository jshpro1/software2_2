/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
public class TelecomDiscount implements Discount {

    public TelecomDiscount(Discount discount) {
    }
    @Override
    public double getDiscount(double price) {
        return price * 0.95;
    }
}
