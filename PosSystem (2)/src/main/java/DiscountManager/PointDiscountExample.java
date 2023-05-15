/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
import java.util.Scanner;

public class PointDiscountExample {

    public static void main(String[] args) {
        Discount discount = new BaseDiscount(); // 기본 할인
        double price = 50000;

        // 포인트 할인
        discount = new PointDiscount(discount, 10000);
        double discountedPrice = discount.applyDiscount(price);
        System.out.println("포인트 할인 후 가격: " + discountedPrice);

        // 통신사 할인
        discount = new TelecomDiscount(discount);
        discountedPrice = discount.applyDiscount(price);
        System.out.println("통신사 할인 후 가격: " + discountedPrice);

        // 제휴할인
        discount = new AffiliateDiscount(discount);
        discountedPrice = discount.applyDiscount(price);
        System.out.println("제휴할인 후 가격: " + discountedPrice);

        // 포인트 할인과 통신사 할인 조합
        discount = new PointDiscount(new TelecomDiscount(new BaseDiscount()), 10000);
        discountedPrice = discount.applyDiscount(price);
        System.out.println("포인트 할인과 통신사 할인 조합 후 가격: " + discountedPrice);

        // 제휴할인과 포인트 할인 조합
        discount = new AffiliateDiscount(new PointDiscount(new BaseDiscount(), 10000));
        discountedPrice = discount.applyDiscount(price);
        System.out.println("제휴할인과 포인트 할인 조합 후 가격: " + discountedPrice);
    }
}
