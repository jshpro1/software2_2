/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itemManager;

/**
 *
 * @author jsh
 *  물품들을 파일에 삽입 삭제 수정 할수있는 코드들
 */
import com.mycompany.possystem.*;
import java.io.*;
import java.util.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ItemManager {
        public static void main(String[] args) {
        // 물품 정보를 저장할 파일 이름과 경로 설정
        String fileName = "items.txt";
        File file = new File(fileName);

        try {
            // 파일이 존재하지 않으면 새로 생성
            if (!file.exists()) {
                file.createNewFile();
            }

            // 파일에 물품 정보 쓰기
            FileWriter writer = new FileWriter(fileName, true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("물품 이름: ");
            String name = scanner.nextLine();

            // 같은 물품 이름이 있는 경우 경고 메시지 출력
            if (searchFile(file, name)) {
                System.out.println("같은 이름의 물품이 이미 존재합니다.");
            } else {
                System.out.print("물품 가격: ");
                int price = Integer.parseInt(scanner.nextLine());

                System.out.print("물품 재고: ");
                int stock = Integer.parseInt(scanner.nextLine());

                writer.write(name + "," + price + "," + stock + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 물품 이름 검색
    public static boolean searchFile(File file, String name) throws IOException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemInfo = line.split(",");

            if (itemInfo[0].equals(name)) {
                return true;
            }
        }

        scanner.close();
        return false;
    }
}

