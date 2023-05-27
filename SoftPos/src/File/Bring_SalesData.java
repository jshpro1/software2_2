/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.PayManagement.payment.*;
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
public class Bring_SalesData {
    public ArrayList<Sales> slist;
    public Bring_SalesData(){
        try {
            String result = null;
            StringBuilder sbuild = new StringBuilder();
            result = new BufferedReader(new FileReader(".\\Sales_Data.json")).readLine();

            sbuild.append(result);
            Type menuListType = null;
            menuListType = new TypeToken<ArrayList<Sales>>() {
            }.getType();
            slist = new ArrayList<Sales>();
            slist = new Gson().fromJson(result, menuListType);


        } catch (Exception e) {
            slist = new ArrayList<Sales>();
            e.printStackTrace();
        }
    }
}
