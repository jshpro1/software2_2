/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.possystem;

/**
 *
 * @author jsh
 *  물품들을 파일에 삽입 삭제 수정 할수있는 코드들
 */
import java.io.*;
import java.util.*;


ㅈ
public class ItemManager {
    private List<Item> itemList = new ArrayList<>();
    private File file = new File("itemList.txt");
    
    public ItemManager() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        else {
            loadItems();
        }
    }
    //새로운 물품을 추가
    public void addItem(Item item) throws IOException {
        if (isDuplicate(item)) {
            System.out.println("이미 등록된 물품입니다.");
            return;
        }
        itemList.add(item);
        saveItems();
    }
    //물품을 삭제
    public void deleteItem(String name) throws IOException {
        Item item = getItem(name);
        if (item == null) {
            System.out.println("해당 물품이 존재하지 않습니다.");
            return;
        }
        itemList.remove(item);
        saveItems();
    }
    //물품의 가격 정보를 수정
    public void editItem(String name, double price) throws IOException {
        Item item = getItem(name);
        if (item == null) {
            System.out.println("해당 물품이 존재하지 않습니다.");
            return;
        }
        item.price = price;
        saveItems();
    }
    
    public void printItemList() {
        for (Item item : itemList) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
    }
    
    //같은 이름을 가진 물품이 이미 존재하는지 확인
    private boolean isDuplicate(Item item) {
        for (Item i : itemList) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
    
    private Item getItem(String name) {
        for (Item item : itemList) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    
    //물품을 파일에 저장
    private void saveItems() throws IOException {
        FileWriter writer = new FileWriter(file);
        for (Item item : itemList) {
            writer.write(item.getName() + "," + item.getPrice() + "\n");
        }
        writer.close();
    }
    
    private void loadItems() throws IOException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            Item item = new Item(parts[0], Double.parseDouble(parts[1]));
            itemList.add(item);
        }
        scanner.close();
    }
}

