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
import java.text.*;
import java.util.*;

public class PaymentManager {
    private Map<Integer, String[]> payInfo;
    private Map<String, Command> commands;
    private Scanner scanner;
    private String filePath;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PaymentManager(String filePath) {
        this.filePath = filePath;
        payInfo = new HashMap<>();
        commands = new HashMap<>();
        scanner = new Scanner(System.in);

        commands.put("card", new CardPayCommand(payInfo, scanner));
        commands.put("cash", new CashPayCommand(payInfo, scanner));
        commands.put("mobile", new MobilePayCommand(payInfo, scanner));
        commands.put("receipt", new ReceiptCommand(payInfo, scanner));
    }
    
    public void run() {
        loadPayInfoFromFile(filePath);
        
        while (true) {
            System.out.println("========== 결제 관리 ==========");
            System.out.println("1. 카드 결제 (card)");
            System.out.println("2. 현금 결제 (cash)");
            System.out.println("3. 모바일 결제 (mobile)");
            System.out.println("4. 영수증 출력 (receipt)");
            System.out.println("5. 종료 (quit)");
            System.out.print("원하는 작업을 선택하세요: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("quit")) {
                break;
            }

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
                savePayInfo(filePath);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }
    
    private void savePayInfo(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<Integer, String[]> entry : payInfo.entrySet()) {
                int payNumber = entry.getKey();
                String payMenu = entry.getValue()[0];
                String payType = entry.getValue()[1];
                String payDate = entry.getValue()[2];
                
                writer.printf("%d,%s,%s,%s\n", payNumber, payMenu, payType, payDate);
            }
            System.out.println("결제 정보가 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("결제 정보를 저장하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }

    private void loadPayInfoFromFile(String filePath) {
        try ( Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    System.out.println("잘못된 형식의 결제 정보입니다: " + line);
                    continue;
                }
                int payNumber = Integer.parseInt(parts[0].trim());
                String payMenu = parts[1].trim();
                String payType = parts[2].trim();
                String payDate = parts[3].trim();

                payInfo.put(payNumber, new String[]{payMenu, payType, payDate});
            }
        } catch (FileNotFoundException e) {
            System.out.println("결제 정보 파일을 찾을 수 없습니다: " + filePath);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 결제 정보가 포함되어 있습니다.");
        }
    }
}
