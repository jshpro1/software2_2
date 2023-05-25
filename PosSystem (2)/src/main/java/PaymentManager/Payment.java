/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManager;

/**
 *
 * @author USER
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Payment {

    private Map<Integer, String[]> payInfo = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void CardPay(double price) {
        loadPayInfoFromFile("payinfo.txt");
        System.out.println("========== 카드 결제 ==========");

        //마지막 결제번호 가져오기
        int lastPayNumber = 0;
        for (Integer payNumber : payInfo.keySet()) {
            if (payNumber > lastPayNumber) {
                lastPayNumber = payNumber;
            }
        }

        // 결제 내역 생성
        int payNumber = lastPayNumber + 1;
        String payMenu = "testing_card"; // 결제 내용 받아오기
        double payPrice = price;// 결제 내용 받아와서 금액 계산하기
        String payType = "카드 결제";
        String payDate = dateFormat.format(new Date());

        System.out.println("결제 번호: " + payNumber);
        System.out.println("결제 내용: " + payMenu);
        System.out.println("결제 금액: " + payPrice);
        System.out.println("결제 수단: " + payType);
        System.out.println("결제 일자: " + payDate);
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");

        payInfo.put(payNumber, new String[]{String.valueOf(payPrice), payMenu, payType, payDate});
        savePayInfo("payinfo.txt", payInfo);
    }

    public void CashPay() {
        loadPayInfoFromFile("payinfo.txt");
        System.out.println("========== 현금 결제 ==========");

        //마지막 결제번호 가져오기
        int lastPayNumber = 0;
        for (Integer payNumber : payInfo.keySet()) {
            if (payNumber > lastPayNumber) {
                lastPayNumber = payNumber;
            }
        }

        // 결제 내역 생성
        int payNumber = lastPayNumber + 1;
        String payMenu = "testing_cash"; // 결제 내용 받아오기
        String payPrice = "testing_cash"; // 결제 내용 받아와서 금액 계산하기
        String payType = "현금 결제";
        String payDate = dateFormat.format(new Date());

        System.out.println("결제 번호: " + payNumber);
        System.out.println("결제 내용: " + payMenu);
        System.out.println("결제 금액: " + payPrice);
        System.out.println("결제 수단: " + payType);
        System.out.println("결제 일자: " + payDate);
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");

        payInfo.put(payNumber, new String[]{payPrice, payMenu, payType, payDate});
        savePayInfo("payinfo.txt", payInfo);
    }

    public void MobilePay() {
        loadPayInfoFromFile("payinfo.txt");
        System.out.println("========== 모바일 결제 ==========");

        //마지막 결제번호 가져오기
        int lastPayNumber = 0;
        for (Integer payNumber : payInfo.keySet()) {
            if (payNumber > lastPayNumber) {
                lastPayNumber = payNumber;
            }
        }

        // 결제 내역 생성
        int payNumber = lastPayNumber + 1;
        String payMenu = "testing_mobile"; // 결제 내용 받아오기
        String payPrice = "testing_mobile"; // 결제 내용 받아와서 금액 계산하기
        String payType = "모바일 결제";
        String payDate = dateFormat.format(new Date());

        System.out.println("결제 번호: " + payNumber);
        System.out.println("결제 내용: " + payMenu);
        System.out.println("결제 금액: " + payPrice);
        System.out.println("결제 수단: " + payType);
        System.out.println("결제 일자: " + payDate);
        System.out.println("결제내역이 추가되었습니다.");
        System.out.println("===============================");

        payInfo.put(payNumber, new String[]{payPrice, payMenu, payType, payDate});
        savePayInfo("payinfo.txt", payInfo);
    }

    public void showReceipt(Scanner scanner) {
        System.out.println("========== 영수증 출력 ==========");
        System.out.print("출력할 영수증의 결제 번호를 입력하세요: ");
        int payNumber = scanner.nextInt();
        scanner.nextLine();

        // 결제 내역 불러오기
        loadPayInfoFromFile("payinfo.txt");

        // 결제 번호에 해당하는 결제 내역 찾기
        String[] payment = payInfo.get(payNumber);

        if (payment != null) {
            String payMenu = payment[0];
            String payPrice = payment[1];
            String payType = payment[2];
            String payDate = payment[3];

            System.out.println("결제 번호: " + payNumber);
            System.out.println("결제 내용: " + payMenu);
            System.out.println("결제 금액: " + payPrice);
            System.out.println("결제 수단: " + payType);
            System.out.println("결제 일자: " + payDate);
            System.out.println("===============================");
        } else {
            System.out.println("해당 결제 번호의 결제 내역을 찾을 수 없습니다.");
        }
    }

    public void savePayInfo(String filePath, Map<Integer, String[]> payinfo) {
        try ( PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<Integer, String[]> entry : payinfo.entrySet()) {
                int payNumber = entry.getKey();
                String payMenu = entry.getValue()[0];
                String payPrice = entry.getValue()[1];
                String payType = entry.getValue()[2];
                String payDate = entry.getValue()[3];

                writer.printf("%d,%s,%s,%s,%s\n", payNumber, payMenu, payPrice, payType, payDate);
            }
            System.out.println("결제 정보가 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("결제 정보를 저장하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }

    public void loadPayInfoFromFile(String filePath) {
        try ( Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length != 5) {
                    System.out.println("잘못된 형식의 결제 정보가 있습니다.");
                    continue;
                }
                int payNumber = Integer.parseInt(parts[0].trim());
                String payMenu = parts[1].trim();
                String payPrice = parts[2].trim();
                String payType = parts[3].trim();
                String payDate = parts[4].trim();

                payInfo.put(payNumber, new String[]{payMenu, payPrice, payType, payDate});
            }
        } catch (FileNotFoundException e) {
            System.out.println("결제 정보 파일을 찾을 수 없습니다: " + filePath);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 결제 정보가 포함되어 있습니다.");
        }
    }
}
