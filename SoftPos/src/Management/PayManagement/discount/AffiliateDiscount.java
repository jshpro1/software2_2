/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.discount;

/**
 *
 * @author jsh
 */
//???댄???? 3%
public class AffiliateDiscount extends DiscountDecorator {

    public String type = "";

    public AffiliateDiscount(Discount discount, String type) {
        this.discount = discount;
        this.type = type;
    }

    @Override
    public int applyDiscount() {
        switch (type) {
            case "우리은행":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "기업은행":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "카카오뱅크":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "토스뱅크":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
        }
        return 0;
    }
}
