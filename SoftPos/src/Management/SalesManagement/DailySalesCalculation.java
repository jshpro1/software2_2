/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.SalesManagement;

/**
 *
 * @author jsh
 */
import Management.PayManagement.receipt.Receipt;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DailySalesCalculation implements SalesCalculation {

    private int inputMonth;
    private int inputDay;

    public DailySalesCalculation(int inputMonth, int inputDay) {
        this.inputMonth = inputMonth;
        this.inputDay = inputDay;
    }

    @Override
    public int calculate(ArrayList<Receipt> receipts) {
//        int totalSales = 0;
//        for (Receipt rcpt : receipts) {
//            LocalDate saleDate = sale.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            if (saleDate.getMonthValue() == inputMonth && saleDate.getDayOfMonth() == inputDay) {
//                totalSales += sale.getTotalPrice();
//            }
//        }
//        return totalSales;
        return 0;
    }
}
