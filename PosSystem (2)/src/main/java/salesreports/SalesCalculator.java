/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreports;

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

    public int calculateSales(List<Sale> sales) {
        return calculationMethod.calculate(sales);
    }
}