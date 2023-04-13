/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.possystem;

/**
 *
 * @author jsh
 */
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Product {
    private String name;
    private int price;
    private Image image;

    public Product(String name, int price, Image image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();

        // 파일에서 물품 정보 읽어오기
        try {
            File file = new File("products.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);
                String imagePath = tokens[2];
                Image image = null;
                // 이미지 파일 경로로부터 이미지 로드하기
                // 예시로 ImageIcon을 사용한 코드
                ImageIcon icon = new ImageIcon(imagePath);
                if (icon != null) {
                    image = icon.getImage();
                }
                Product product = new Product(name, price, image);
                productList.add(product);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 물품 추가
        // 이미지는 따로 추가해야 함

        // 물품 삭제
        productList.removeIf(product -> product.getName().equals("삭제할 물품"));

        // 물품 수정
        for (Product product : productList) {
            if (product.getName().equals("수정할 물품")) {
                product.setPrice(10000);
            }
        }

        // 파일에 물품 정보 저장하기
        try {
            File file = new File("products.txt");
            FileWriter writer = new FileWriter(file);
            for (Product product : productList) {
                String imagePath = ""; // 이미지 파일 경로
                if (product.getImage() != null) {
                    // 이미지 파일 경로 설정
                }
                String line = product.getName() + "," + product.getPrice() + "," + imagePath + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}