/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.Stock;

/**
 *
 * @author 남진우
 */
public abstract class Stock { //재고
    
    protected String name;
    protected int unit_price; //100그람 기준 가격
    protected int kcal; //칼로리
    protected int pcs; // 재고 수 
    
    public int getPrice(){
        return unit_price;
    }
    public abstract String kind(); // 임시 재고 판별책
}
