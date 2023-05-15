/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
public class PointDiscount implements Discount {
    private double point;

    public PointDiscount(double point) {
        this.point = point;
    }

    @Override
    public double getDiscount(double price) {
        return price - point;
    }
}