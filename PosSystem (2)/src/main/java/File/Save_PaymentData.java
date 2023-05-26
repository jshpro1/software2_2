package File;

import Management.PayManagement.payment.*;
import com.google.gson.Gson;
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
public class Save_PaymentData {
    
    public Save_PaymentData(ArrayList<Payment> mlist) {
        try {

            File file = null;
            Gson gs = new Gson();
            file = new File("Payment_Data.json");

            FileWriter writer = new FileWriter(file);
            String fileWriter = gs.toJson(mlist);
            System.out.println(fileWriter);

            writer.write(fileWriter);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
