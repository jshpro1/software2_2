/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

/**
 *
 * @author USER
 */
import java.util.*;

public class Payment_Card implements Command {

    private Process_Card proc;

    public Payment_Card(Process_Card proc) {
        this.proc = proc;
    }

    public void execute() {
        proc.makeCardReceipt();
    }
}
