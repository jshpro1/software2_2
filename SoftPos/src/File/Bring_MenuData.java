/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Management.MenuManagement.Menu.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author ³²Áø¿ì
 */
public class Bring_MenuData {

    public ArrayList<Menu> mlist;

    public Bring_MenuData() {

        try {
            String result = null;
            StringBuilder sbuild = new StringBuilder();
            result = new BufferedReader(new FileReader(".\\Menu_Data.json")).readLine();

            sbuild.append(result);
            Type menuListType = null;
            menuListType = new TypeToken<ArrayList<Menu>>() {
            }.getType();
            mlist = new ArrayList<Menu>();
            mlist = new Gson().fromJson(result, menuListType);


        } catch (Exception e) {
            mlist = new ArrayList<Menu>();
            e.printStackTrace();
        }
    }
}
