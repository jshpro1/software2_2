/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import com.google.gson.Gson;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 남진우
 */
public class OrderCarculator {

    private int total_amount;
    private int disc_amount;
    public Object[][] ob ;
    public Vector av ;
    public Vector<Vector> orderlist;

    public OrderCarculator(Vector<Vector> orderlist, Object[][] ob) {
        this.ob = ob;
        this.orderlist = orderlist;
    }
    
    public void setAmounts(DefaultTableModel atm,int ra){// ra는 받을돈

        atm.setRowCount(0);
        setTotalAmount(); // 총금액 계산
//        setdiscAmount(); // 할인금액 계산
        setToBeReceiveAmount(); // 받을 돈 계산
        setReceiveAmount(ra); // 받은돈
        setChange(ra); // 거스름돈 계산
        setAmountVector(); 
        
        
        for(int i = 0 ; i < av.size(); i++){
            atm.addRow((Object[])av.get(i));
        }
        atm.fireTableDataChanged();
    }
   
    
    
    public void setTotalAmount(){
        total_amount = 0;
        for(Vector vec : orderlist){
            total_amount += (int)vec.get(4);
        }
        ob[0][1] = total_amount;
    }
    public void setdiscAmount(){
    }
    
    public void setToBeReceiveAmount(){
        ob[2][1] = total_amount - (int)ob[1][1];
    }
    public void setReceiveAmount(int ra){
        ob[3][1] =  ra; // 받은 돈
    }
    public void setChange(int ra){
        ob[4][1] = ra - (total_amount - (int)ob[1][1]);
    }
    
    public void setAmountVector(){
        av = new Vector();
        av.add(ob[0]);
        av.add(ob[1]);
        av.add(ob[2]);
        av.add(ob[3]);
        av.add(ob[4]);
    }
            
    
}
