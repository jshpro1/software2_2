/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.receipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author 남진우
 */
public class Receipt {

    //공통
    public String payment;
    public Date date;
    public Vector<Vector> orderlist; // 결제 내역
    public int total_amount;     //총금액
    public int discount; // 할인금액

    public int taxation_amount; //과세금액
    public int surtax_amount; //부가세
    public int pay_amoutn; //결제금액

    //현금 전용
    public int received_amount; // 현금
    public int change; // 거스름돈

    //카드, 모바일 전용
    public String cardnumber;
    public String installment; //할부

    public Receipt() {

        
    }

}
