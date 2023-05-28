/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.MenuManagement.Menu.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 0523 ( ! ) 수정 필요
 *
 * @author 남진우
 */
public class Save_MenuData {

    public Save_MenuData(ArrayList<Menu> mlist) {
        try {

            File file = null;
            Gson gs = new Gson();
            file = new File("Menu_Data.json");

            FileWriter writer = new FileWriter(file);
            String jsontext = gs.toJson(mlist);
            System.out.println(jsontext);

            writer.write(jsontext);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
