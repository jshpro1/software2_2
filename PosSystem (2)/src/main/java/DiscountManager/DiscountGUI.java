/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DiscountManager;

/**
 *
 * @author jsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountGUI extends JFrame {

    private JTextField priceTextField;
    private JTextField discountedPriceTextField;
    private JButton applyButton;
    private JCheckBox affiliateCheckBox;
    private JCheckBox telecomCheckBox;
    private JCheckBox pointCheckBox;
    private JTextField pointTextField;

    public DiscountGUI() {
        setTitle("할인 적용");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel priceLabel = new JLabel("가격: ");
        priceTextField = new JTextField(10);
        applyButton = new JButton("할인 적용");
        topPanel.add(priceLabel);
        topPanel.add(priceTextField);
        topPanel.add(applyButton);

        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new BoxLayout(discountPanel, BoxLayout.Y_AXIS));
        affiliateCheckBox = new JCheckBox("Affiliate 할인");
        telecomCheckBox = new JCheckBox("Telecom 할인");
        pointCheckBox = new JCheckBox("Point 할인");
        discountPanel.add(affiliateCheckBox);
        discountPanel.add(Box.createVerticalStrut(10));
        discountPanel.add(telecomCheckBox);
        discountPanel.add(Box.createVerticalStrut(10));
        discountPanel.add(pointCheckBox);

        JPanel pointPanel = new JPanel(new FlowLayout());
        pointTextField = new JTextField(10);
        pointTextField.setEnabled(false);
        pointPanel.add(pointCheckBox);
        JLabel pointLabel = new JLabel("사용할 포인트: ");
        pointTextField = new JTextField(10);
        pointTextField.setEnabled(false);
        pointPanel.add(pointLabel);
        pointPanel.add(pointTextField);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JLabel discountpriceLabel = new JLabel("할인된 가격: ");
        discountedPriceTextField = new JTextField(10);
        bottomPanel.add(priceLabel);
        discountedPriceTextField.setEditable(false);
        bottomPanel.add(discountedPriceTextField);

        JPanel sidePanel = new JPanel(new GridLayout(3, 1));
        sidePanel.add(discountPanel);
        sidePanel.add(pointPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        pointCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointTextField.setEnabled(pointCheckBox.isSelected());
            }
        });

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = Double.parseDouble(priceTextField.getText());
                double discountedPrice = price;

                if (affiliateCheckBox.isSelected()) {
                    Discount affiliateDiscount = new AffiliateDiscount(null);
                    discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
                }

                if (telecomCheckBox.isSelected()) {
                    Discount telecomDiscount = new TelecomDiscount(null);
                    discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
                }

                if (pointCheckBox.isSelected()) {
                    double point = Double.parseDouble(pointTextField.getText());
                    Discount pointDiscount = new PointDiscount(null, point);
                    discountedPrice = pointDiscount.applyDiscount(discountedPrice);
                }

                discountedPriceTextField.setText(String.valueOf(discountedPrice));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiscountGUI discountGUI = new DiscountGUI();
                discountGUI.setVisible(true);
            }
        });
    }
}
