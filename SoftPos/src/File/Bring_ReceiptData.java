/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.PayManagement.payment.*;
import Management.PayManagement.receipt.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Bring_ReceiptData {

    public ArrayList<Receipt> rlist;

    public Bring_ReceiptData() {

        try {
            String result = null;
            StringBuilder sbuild = new StringBuilder();
            result = new BufferedReader(new FileReader(".\\Receipt_Data.json")).readLine();

            sbuild.append(result);
            Type menuListType = null;
            menuListType = new TypeToken<ArrayList<Receipt>>() {
            }.getType();
            rlist = new ArrayList<Receipt>();
            rlist = new Gson().fromJson(result, menuListType);


        } catch (Exception e) {
            rlist = new ArrayList<Receipt>();
            e.printStackTrace();
        }
    }
}