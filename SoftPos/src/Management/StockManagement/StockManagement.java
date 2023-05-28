/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 남진우
 */
public class StockManagement implements Subject {

    private ArrayList<StockManager> stockmanagers; //재고 관리자 명단
    private Vector vlist; // 테이블 삽입할 때 쓰는 벡터
//    private ArrayList<Stock> slist; // 값 수정할 때 쓰는 재고 리스트

    public StockManagement() {
        stockmanagers = new ArrayList<StockManager>();

        //임시 선언
        
        bringStockData();

    }

    public void setStocksTable(String type, DefaultTableModel tm) {
        tm.setRowCount(0);

        
        for (StockManager sm : stockmanagers) {
            
            if (sm.identify().equals(type)) {

                for (Stock stk : sm.getStocksList()) {
                    vlist = new Vector();
                    vlist.add(stk.getName());
                    vlist.add(stk.getKcal());
                    vlist.add(stk.getPrice());
                    vlist.add(stk.getPcs());
                    tm.addRow(vlist);
                }
            }else if (type.equals("All")){
                for (Stock stk : sm.getStocksList()) {
                    vlist = new Vector();
                    vlist.add(stk.getName());
                    vlist.add(stk.getKcal());
                    vlist.add(stk.getPrice());
                    vlist.add(stk.getPcs());
                    tm.addRow(vlist);
                }
            }
        }
        tm.fireTableDataChanged();
    }

    public void setStocksData(String sname, int pcs) {
        for (StockManager sm : stockmanagers) {
            for (Stock stk : sm.getStocksList()) {
                if (stk.getName().equals(sname)) {
                    stk.setPcs(pcs + stk.getPcs());
//                    System.out.println(stk.kind());
                }
            }
        }
    }
    public void setAllStocksData( int pcs) {
        for (StockManager sm : stockmanagers) {
            for (Stock stk : sm.getStocksList()) {
                    stk.setPcs(pcs + stk.getPcs());
            }
        }
    }

    public void addStockManager(StockManager o) { // 명단에 관리자 추가

        stockmanagers.add(o);
    }

    public void removeStockManager(StockManager o) {  // 명단에서 삭제
        stockmanagers.remove(o);
    }

    public void notifyStockManager() { // 구독자들한테 알림
        for (StockManager sm : stockmanagers) {  // 모든 관리자 돌면서 실행
            sm.updateStockData(sm.getStocksList());
        }
    }

    public void bringStockData() {
        for (StockManager sm : stockmanagers) {
            sm.setStocksList(new Bring_StockData(sm.identify()).slist);
        }
    }

}
