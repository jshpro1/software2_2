/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itemManager;

import com.mycompany.possystem.*;

/**
 *
 * @author jsh
 *  Item 물품 이름과 가격 정보를 저장
 */
public class Item {
    private String name;
    double price;
    int inventory;
    
    public Item(String name, double price,int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getinventory(){
        return inventory;
    }
}
