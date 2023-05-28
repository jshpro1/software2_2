/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Payment_Cash implements Command{
    private Process_Cash proc;

    public Payment_Cash(Process_Cash proc) {
        this.proc = proc;
    }

    public void execute() {
        proc.CashReceiptProcessing();
    }
}
