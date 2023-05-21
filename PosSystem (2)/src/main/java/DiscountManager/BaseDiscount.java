/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
//할인 적용 업는 클래스
public class BaseDiscount implements Discount {

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
