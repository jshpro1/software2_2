/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreports;
/**
 *
 * @author jsh
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class WeeklySalesCalculation implements SalesCalculation {
    @Override
    public int calculate(List<Sale> sales) {
        int totalSales = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("매출을 계산할 월을 입력하세요 (예 :1~12) : ");
        int selectedMonth = scanner.nextInt();
        System.out.print("매출을 계산할 주을 입력하세요 (예 :1~5) :  ");
        int selectedWeek = scanner.nextInt();

        YearMonth selectedYearMonth = YearMonth.now().withMonth(selectedMonth);
        LocalDate startOfWeek = selectedYearMonth.atDay(1).with(DayOfWeek.MONDAY).plusWeeks(selectedWeek - 1);
        LocalDate endOfWeek = startOfWeek.with(DayOfWeek.SUNDAY);

        for (Sale sale : sales) {
            LocalDate saleDate = sale.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (saleDate.isAfter(startOfWeek) && saleDate.isBefore(endOfWeek)) {
                totalSales += sale.getTotalPrice();
            }
        }

        return totalSales;
    }
}