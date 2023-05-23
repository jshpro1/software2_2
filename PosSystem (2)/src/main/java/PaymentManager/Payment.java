/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManager;

/**
 *
 * @author USER
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Payment {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public void CardPay(Map<Integer, String[]> payinfo, Scanner scanner) {
        System.out.println("========== 카드 결제 ==========");
        
        System.out.println("결제 방법: 카드 결제");
        String payType = "카드 결제";
        
        System.out.print("결제 번호를 입력하세요: ");
        int payNumber = scanner.nextInt();
        scanner.nextLine();
        
        // 중복 체크
        for (Integer re : payinfo.keySet()) {
            if (re.equals(payNumber)) {
                System.out.println("이미 존재하는 결제 번호입니다.");
                return;
            }
        }
        
        System.out.print("결제 내용를 입력하세요: ");
        String payMenu = scanner.nextLine().trim();
        
        String payDate = dateFormat.format(new Date());
        System.out.print("결제 일자: " + payDate + "\n");
        
        payinfo.put(payNumber, new String[]{payMenu, payType, payDate});
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");
    }

    public void CashPay(Map<Integer, String[]> payinfo, Scanner scanner) {
        System.out.println("========== 현금 결제 ==========");
        
        System.out.println("결제 방법: 현금 결제");
        String payType = "현금 결제";
        
        System.out.print("결제 번호를 입력하세요: ");
        int payNumber = scanner.nextInt();
        scanner.nextLine();
        
        // 중복 체크
        for (Integer re : payinfo.keySet()) {
            if (re.equals(payNumber)) {
                System.out.println("이미 존재하는 결제 번호입니다.");
                return;
            }
        }
        
        System.out.print("결제 내용를 입력하세요: ");
        String payMenu = scanner.nextLine().trim();
        
        String payDate = dateFormat.format(new Date());
        System.out.print("결제 일자: " + payDate + "\n");
        
        payinfo.put(payNumber, new String[]{payMenu, payType, payDate});
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");
    }

    public void MobilePay(Map<Integer, String[]> payinfo, Scanner scanner) {
        System.out.println("========== 모바일 결제 ==========");
        
        System.out.println("결제 방법: 모바일 결제");
        String payType = "모바일 결제";
        
        System.out.print("결제 번호를 입력하세요: ");
        int payNumber = scanner.nextInt();
        scanner.nextLine();
        
        // 중복 체크
        for (Integer re : payinfo.keySet()) {
            if (re.equals(payNumber)) {
                System.out.println("이미 존재하는 결제 번호입니다.");
                return;
            }
        }
        
        System.out.print("결제 내용를 입력하세요: ");
        String payMenu = scanner.nextLine().trim();
        
        String payDate = dateFormat.format(new Date());
        System.out.print("결제 일자: " + payDate + "\n");
        
        payinfo.put(payNumber, new String[]{payMenu, payType, payDate});
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");
    }
    
    public void Receipt(Map<Integer, String[]> payinfo, Scanner scanner){
        System.out.println("========== 영수증 ==========");
        System.out.print("결제 번호를 입력하세요: ");
        int payNumber = scanner.nextInt();
        scanner.nextLine();

        String[] payment = payinfo.get(payNumber);
        if (payment != null) {
            String payMenu = payment[0];
            String payType = payment[1];
            String payDate = payment[2];

            System.out.println("결제 번호: " + payNumber);
            System.out.println("결제 방법: " + payType);
            System.out.println("결제 내용: " + payMenu);
            System.out.println("결제 일시: " + payDate);
            System.out.println("=============================");
        } else {
            System.out.println("해당 결제 번호의 영수증을 찾을 수 없습니다.");
        }
    }
}
