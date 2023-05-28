/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.receipt;

import java.util.*;

/**
 *
 * @author 남진우
 */
public class ReceiptMaker {

    private Vector<Vector> orderlist;
    private int total;
    private int discount;
    private int change;
    private int receive;
    public String cardnum;
    public Object[][] ob;
    public String installment;

    public ReceiptMaker(Vector<Vector> orderlist, Object[][] ob, String cardnum, String installment) {

        this.total = (int) ob[0][1];
        this.discount = (int) ob[1][1];
        this.receive = (int) ob[3][1];
        this.change = (int) ob[4][1];
        this.orderlist = orderlist;
        this.cardnum = cardnum;
        this.installment = installment;

    }

    public Receipt MakeCashReceipt() {
        
        Receipt_Cash r = new Receipt_Cash();
        r.payment = "현금";
        r.date = new Date();
        r.orderlist = orderlist;
        r.total_amount = total;
        r.discount = discount;
        r.taxation_amount = (total - discount) / 11 * 10;
        r.surtax_amount = (total - discount) / 11;
        r.pay_amoutn = total - discount;

        r.change = change;
        r.received_amount = receive;

        return r;
    }

    public Receipt MakeCashReciet() {
        Receipt_Card r = new Receipt_Card();
        r.payment = "카드";
        r.date = new Date();
        r.orderlist = orderlist;
        r.total_amount = total;
        r.discount = discount;
        r.taxation_amount = (total - discount) / 11 * 10;
        r.surtax_amount = (total - discount) / 11;
        r.pay_amoutn = total - discount;

        r.cardnumber = cardnum;
        r.installment = installment;
        return r;
    }

    public Receipt MakeSamsungReciet() {
        Receipt_Samsung r = new Receipt_Samsung();
        r.payment = "삼성";
        r.date = new Date();
        r.orderlist = orderlist;
        r.total_amount = total;
        r.discount = discount;
        r.taxation_amount = (total - discount) / 11 * 10;
        r.surtax_amount = (total - discount) / 11;
        r.pay_amoutn = total - discount;

        r.cardnumber = cardnum;
        r.installment = installment;
        return r;

    }

}
