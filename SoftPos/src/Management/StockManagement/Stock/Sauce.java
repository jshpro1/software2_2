/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.Stock;

/**
 *
 * @author ������
 */
public class Sauce extends Stock{
    
    public Sauce(String name, int kcal, int unit_price) {
        this.name = name;
        this.kcal = kcal;
        this.unit_price = unit_price;
    }
    public int getPrice(){
        return unit_price;
    }
    
    public String kind(){
        return "Sauce";
    }
}
