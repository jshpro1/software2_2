/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PaymentManager;

import javax.swing.JTextField;

/**
 *
 * @author jsh
 */
public class PaymentJFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form paymentJFrame
     */
    PaymentManager pay = new PaymentManager();
    public double payPrice = 10000;
    public double totalPayPrice = 0;
    public String payType = "payType";
    public String payText = "payText";
    public int discountRate = 0;
    
    public PaymentJFrame() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mobileButton = new javax.swing.JButton();
        cardButton = new javax.swing.JButton();
        cashButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        totalpriceTextField = new javax.swing.JTextField();
        payButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JToggleButton();
        discountTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        payTypeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        discountapplyButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("총 금 액");

        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        jLabel2.setText("결제창");

        mobileButton.setText("모바일");
        mobileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileButtonActionPerformed(evt);
            }
        });

        cardButton.setText("카드");
        cardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtonActionPerformed(evt);
            }
        });

        cashButton.setText("현금");
        cashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("결제 금액");

        totalpriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalpriceTextFieldActionPerformed(evt);
            }
        });

        payButton.setText("결제");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("취소");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("할 인 율");

        payTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("결제 방식");

        discountapplyButton.setText("적용");
        discountapplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountapplyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(cardButton)
                                .addGap(18, 18, 18)
                                .addComponent(cashButton)
                                .addGap(18, 18, 18)
                                .addComponent(mobileButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(14, 14, 14))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(payTypeTextField)
                                    .addComponent(priceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(discountTextField)
                                    .addComponent(totalpriceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(discountapplyButton)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashButton)
                    .addComponent(mobileButton)
                    .addComponent(cardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(discountapplyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalpriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void totalpriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalpriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalpriceTextFieldActionPerformed

    private void mobileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileButtonActionPerformed
        // TODO add your handling code here:
        payType = "mobile";
        payText = "모바일 결제";
        
        payTypeTextField.setText(payText);
        priceTextField.setText(String.valueOf(payPrice));
        discountTextField.setText(String.valueOf(discountRate + "%"));
        
        totalPayPrice = payPrice;
        totalpriceTextField.setText(String.valueOf(totalPayPrice));
    }//GEN-LAST:event_mobileButtonActionPerformed

    private void cardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtonActionPerformed
        // TODO add your handling code here:
        payType = "card";
        payText = "카드 결제";
        
        payTypeTextField.setText(payText);
        priceTextField.setText(String.valueOf(payPrice));
        discountTextField.setText(String.valueOf(discountRate + "%"));
        
        totalPayPrice = payPrice;
        totalpriceTextField.setText(String.valueOf(totalPayPrice));
    }//GEN-LAST:event_cardButtonActionPerformed

    private void cashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashButtonActionPerformed
        // TODO add your handling code here:
        payType = "cash";
        payText = "현금 결제";
        
        payTypeTextField.setText(payText);
        priceTextField.setText(String.valueOf(payPrice));
        discountTextField.setText(String.valueOf(discountRate + "%"));
        
        totalPayPrice = payPrice;
        totalpriceTextField.setText(String.valueOf(totalPayPrice));
    }//GEN-LAST:event_cashButtonActionPerformed

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        pay.GUIstart(payType);
    }//GEN-LAST:event_payButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        payType = "quit";
        pay.GUIstart(payType);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void payTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payTypeTextFieldActionPerformed

    private void discountapplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountapplyButtonActionPerformed
        // TODO add your handling code here:
        discountRate = 10;
        discountTextField.setText(String.valueOf(discountRate + "%"));
    }//GEN-LAST:event_discountapplyButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cancelButton;
    private javax.swing.JButton cardButton;
    private javax.swing.JButton cashButton;
    private javax.swing.JTextField discountTextField;
    private javax.swing.JToggleButton discountapplyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton mobileButton;
    private javax.swing.JButton payButton;
    private javax.swing.JTextField payTypeTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField totalpriceTextField;
    // End of variables declaration//GEN-END:variables
}
