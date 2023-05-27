/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import Management.PayManagement.receipt.*;
import java.util.*;
/**
 *
 * @author USER
 */
public class Payment {
    public String method;
    public String installment;
    public String cardnumber;
    public Date date;
    public ArrayList<Vector> list;
    public int tax;
    public int surtax;
    public int sum;
    public int discount;
    public int total;
    
    public CardReceipt cdr;
    public CashReceipt csr;
    public MobileReceipt mbr;
    
    public Payment() {
        method = ""; //결제 수단
        cardnumber = ""; //카드 번호
        installment = ""; //할부 개월
        date = new Date(); //결제 일자
        list = new ArrayList<Vector>(); //결제 내용
        tax = 0; //과세
        surtax = 0; //부가세
        sum = 0; //합계
        discount = 0; //할인 금액
        total = 0; //최종 금액
    }
    
    public void CardPay(ArrayList<Payment> payinfo){
        System.out.println("CardPay Execute");
        
        cdr = new CardReceipt();
        cdr.saveCardReceipt(payinfo);
        
        System.out.println("CardPay Success");
    }
    
    public void CashPay(ArrayList<Payment> payinfo){
        System.out.println("CashPay Execute");
        
        csr = new CashReceipt();
        csr.saveCashReceipt(payinfo);
        
        System.out.println("CardPay Success");
    }
    
    public void MobilePay(ArrayList<Payment> payinfo){
        System.out.println("MobilePay Execute");
        
        mbr = new MobileReceipt();
        mbr.saveMobileReceipt(payinfo);
        
        System.out.println("CardPay Success");
    }
}
