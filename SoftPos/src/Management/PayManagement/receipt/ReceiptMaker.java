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
    public Receipt receipt;
    public String type;

    public ReceiptMaker(String type, Vector<Vector> orderlist, Object[][] ob, String cardnum, String installment) {
        receipt = new Receipt();
        this.type = type;
        this.total = (int) ob[0][1];
        this.discount = (int) ob[1][1];
        this.receive = (int) ob[3][1];
        this.change = (int) ob[4][1];
        this.orderlist = orderlist;
        this.cardnum = cardnum;
        this.installment = installment;

    }

    public Receipt MakeReceipt() {

        receipt.payment = "현금";
        receipt.date = new Date();
        receipt.orderlist = orderlist;
        receipt.total_amount = total;
        receipt.discount = discount;
        receipt.taxation_amount = (total - discount) / 11 * 10;
        receipt.surtax_amount = (total - discount) / 11;
        receipt.pay_amoutn = total - discount;

        receipt.change = change;
        receipt.received_amount = receive;

        receipt.cardnumber = cardnum;
        receipt.installment = installment;
        return receipt;
    }

}
