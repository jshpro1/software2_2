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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

class DailySalesCalculation implements SalesCalculation {
    @Override
    public int calculate(List<Sale> sales) {
        int totalSales = 0;
        LocalDate today = LocalDate.now();
        for (Sale sale : sales) {
            LocalDate saleDate = sale.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (saleDate.equals(today)) {
                totalSales += sale.getTotalPrice();
            }
        }
        return totalSales;
    }
}