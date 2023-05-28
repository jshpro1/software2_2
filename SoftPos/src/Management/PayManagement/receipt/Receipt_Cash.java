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
public class Receipt_Cash extends Receipt {

    public int received_amount; // 현금
    public int change; // 거스름돈

    public String receipt_type; //자진발급인지 지출증빙인지
    public String check_number; // 확인번호 전화번호

    /*
    영수증 출럭부분
    */
    public String veiwReceipt() {
        return null;
    }

}
