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
public class Payment_Samsung implements Command{
    private Process_Samsung proc;

    public Payment_Samsung(Process_Samsung proc) {
        this.proc = proc;
    }

    public void execute() {
        proc.SamsungReceiptProcessing();
    }
}
