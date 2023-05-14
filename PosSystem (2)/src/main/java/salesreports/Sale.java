/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreports;

import java.util.Date;

/**
 *
 * @author jsh
 */
class Sale {

    private Date date;
    private String itemName;
    private int itemPrice;
    private int quantity;
    private int totalPrice;

    public Sale(Date date, String itemName, int itemPrice, int quantity) {
        this.date = date;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.totalPrice = itemPrice * quantity;
    }

    public Date getDate() {
        return date;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}