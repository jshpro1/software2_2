/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.possystem;

/**
 *  4/11
 * @author bgn
 * @author jsh
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PosSystem {
    private static List<Double> sales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        double payment = 0;
        double change = 0;

        while (true) {
            System.out.println("판매할 메뉴의 가격을 입력하세요 (종료하려면 0 입력): ");
            double price = scanner.nextDouble();
            if (price == 0) {
                break;
            }
            total += price;
        }

        System.out.println("총 판매 금액은 " + total + "원 입니다.");

        while (true) {
            System.out.println("지불할 금액을 입력하세요: ");
            payment = scanner.nextDouble();
            change = payment - total;
            if (change >= 0) {
                break;
            } else {
                System.out.println("금액이 부족합니다. 다시 입력해주세요.");
            }
        }

        System.out.println("거스름돈은 " + change + "원 입니다.");
        sales.add(total);

        System.out.println("판매가 완료되었습니다.");

        while (true) {
            System.out.println("계속해서 판매하시겠습니까? (Y/N)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                main(args);
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public static void printSales() {
        System.out.println("지금까지의 총 판매 금액은 " + sales.stream().mapToDouble(Double::doubleValue).sum() + "원 입니다.");
    }
}