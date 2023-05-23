/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaymentManager;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        String filePath = "payInfo.txt";
        PaymentManager paymentManager = new PaymentManager(filePath);
        paymentManager.run();
    }
}
