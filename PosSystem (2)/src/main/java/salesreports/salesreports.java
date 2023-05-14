
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salesreports;

/**
 *
 * @author jsh
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class salesreports {

    public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();
        // sales.txt 파일에서 데이터를 읽어옴
        try ( BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String itemName = tokens[0];
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[1]);

                int itemPrice = Integer.parseInt(tokens[2]);
                int quantity = Integer.parseInt(tokens[3]);
                Sale sale = new Sale(date, itemName, itemPrice, quantity);
                sales.add(sale);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // 일일, 주간, 월간, 전체의 매출액을 계산
        SalesCalculator dailySalesCalculator = new SalesCalculator(new DailySalesCalculation());
        int dailySales = dailySalesCalculator.calculateSales(sales);

        SalesCalculator weeklySalesCalculator = new SalesCalculator(new WeeklySalesCalculation());
        int weeklySales = weeklySalesCalculator.calculateSales(sales);

        SalesCalculator monthlySalesCalculator = new SalesCalculator(new MonthlySalesCalculation());
        int monthlySales = monthlySalesCalculator.calculateSales(sales);

        int totalSales = dailySales;

        // 사용자가 선택한 계산 방법에 따라 매출액을 출력
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하는 매출액 계산 방법을 선택하세요.");
        System.out.println("1. 일일 매출액");
        System.out.println("2. 주간 매출액");
        System.out.println("3. 월간 매출액");
        System.out.println("4. 전체 매출액");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("일일 매출액: " + dailySales);
                totalSales = dailySales;
                break;
            case 2:
                System.out.println("주간 매출액: " + weeklySales);
                totalSales = weeklySales;
                break;
            case 3:
                System.out.println("월간 매출액: " + monthlySales);
                totalSales = monthlySales;
                break;
            default:
                System.out.println("전체 매출액: " + totalSales);
                break;
        }
    }

}