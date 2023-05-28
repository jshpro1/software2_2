/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.SalesManagement;

import Management.PayManagement.receipt.Receipt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsh
 */
public class SalesCalculator {
    private SalesCalculation calculationMethod;

    public SalesCalculator(SalesCalculation calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    public int calculateSales(ArrayList<Receipt>  sales) {
        return calculationMethod.calculate(sales);
    }
}