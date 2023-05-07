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
    int price;
    int stock;
    
    public Item(String name, int price,int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getstock(){
        return stock;
    }
}
