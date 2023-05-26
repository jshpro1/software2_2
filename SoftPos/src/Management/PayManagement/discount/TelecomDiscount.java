/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.discount;

/**
 *
 * @author jsh
 */
//?µì???? ???? 5%
public class TelecomDiscount extends DiscountDecorator {

    private String type;

    public TelecomDiscount(Discount discount, String type) {
        this.discount = discount;
        this.type = type;
    }

    @Override
    public int applyDiscount() {
        switch (type) {
            case "SKT":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "KT":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "LGU+":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
        }
        return 0;
    }
}
