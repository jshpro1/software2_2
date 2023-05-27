package File;

import Management.PayManagement.payment.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Save_ReceiptData {

    public Save_ReceiptData(ArrayList<Payment> rlist) {
        try {
            //날짜저장형식지정
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd") // JSON으로 저장할 때 날짜 형식 지정
                    .create();
            
            //저장경로
            FileWriter writer = new FileWriter("Receipt_Data.json");
            
            //확인용
            String fileWriter = gson.toJson(rlist);
            System.out.println(fileWriter);
            
            gson.toJson(rlist, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
