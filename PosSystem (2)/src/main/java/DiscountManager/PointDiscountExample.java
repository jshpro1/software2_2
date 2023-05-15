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
        Scanner scanner = new Scanner(System.in);

        System.out.print("상품 가격을 입력하세요: ");
        double price = scanner.nextDouble();

        System.out.print("사용할 포인트를 입력하세요: ");
        double point = scanner.nextDouble();

        Discount discount = new PointDiscount(point);
        double discountedPrice = discount.getDiscount(price);

        System.out.printf("할인 후 가격은 %.2f원 입니다.", discountedPrice);
    }
}
