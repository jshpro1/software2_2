/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreports;

/**
 *
 * @author jsh
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class MonthlySalesCalculation implements SalesCalculation {
    @Override
    public int calculate(List<Sale> sales) {
        int totalSales = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("매출을 계산할 월을 입력하세요 (예: 1~12) : ");
        int inputMonth = sc.nextInt();
        for (Sale sale : sales) {
            LocalDate saleDate = sale.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (saleDate.getMonthValue() == inputMonth) {
                totalSales += sale.getTotalPrice();
            }
        }
        return totalSales;
    }
}