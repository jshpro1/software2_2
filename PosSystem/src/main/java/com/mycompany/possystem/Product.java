/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.possystem;

/**
 *
 * @author jsh
 * 이미지 뺀 코드
 */
import java.io.*;
import java.util.*;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
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
                Product product = new Product(name, price);
                productList.add(product);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 물품 추가
        Product newProduct = new Product("새로운 물품", 5000);
        productList.add(newProduct);

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
                String line = product.getName() + "," + product.getPrice() + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
