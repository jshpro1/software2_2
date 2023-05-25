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
    private JComboBox<String> affiliateComboBox; // 제휴 할인 콤보박스
    private JCheckBox telecomCheckBox;
    private JComboBox<String> telecomComboBox; // 통신사 할인 콤보박스
    private JCheckBox cashCheckBox;
    private JTextField cashTextField;

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

        JPanel affiliatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        affiliateCheckBox = new JCheckBox("제휴 할인");
        String[] affiliateOptions = {"우리은행", "국민은행", "토스은행", "카카오뱅크"};
        affiliateComboBox = new JComboBox<>(affiliateOptions);
        affiliateComboBox.setEnabled(false);
        affiliatePanel.add(affiliateCheckBox);
        affiliatePanel.add(affiliateComboBox);

        JPanel telecomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        telecomCheckBox = new JCheckBox("통신사 할인");
        String[] telecomOptions = {"KT", "SKT", "LG U+"};
        telecomComboBox = new JComboBox<>(telecomOptions);
        telecomComboBox.setEnabled(false);
        telecomPanel.add(telecomCheckBox);
        telecomPanel.add(telecomComboBox);

        JPanel pointPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cashCheckBox = new JCheckBox("현금 할인");
        cashTextField = new JTextField(10);
        cashTextField.setEnabled(false);
        pointPanel.add(cashCheckBox);
        JLabel pointLabel = new JLabel("할인할 금액: ");
        pointPanel.add(pointLabel);
        pointPanel.add(cashTextField);

        discountPanel.add(affiliatePanel);
        discountPanel.add(telecomPanel);
        discountPanel.add(pointPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JLabel discountPriceLabel = new JLabel("할인된 가격: ");
        discountedPriceTextField = new JTextField(10);
        bottomPanel.add(discountPriceLabel);
        discountedPriceTextField.setEditable(false);
        bottomPanel.add(discountedPriceTextField);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(discountPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        affiliateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affiliateComboBox.setEnabled(affiliateCheckBox.isSelected());
            }
        });

        telecomCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telecomComboBox.setEnabled(telecomCheckBox.isSelected());
            }
        });

        cashCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashTextField.setEnabled(cashCheckBox.isSelected());
            }
        });

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = Double.parseDouble(priceTextField.getText());
                double discountedPrice = price;

                if (affiliateCheckBox.isSelected()) {
                    String affiliateOption = (String) affiliateComboBox.getSelectedItem();
                    if (affiliateOption.equals("우리은행")) {
                        Discount affiliateDiscount = new AffiliateDiscount(null);
                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
                    } else if (affiliateOption.equals("국민은행")) {
                        Discount affiliateDiscount = new AffiliateDiscount(null);
                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
                    } else if (affiliateOption.equals("토스은행")) {
                       Discount affiliateDiscount = new AffiliateDiscount(null);
                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
                    } else if (affiliateOption.equals("카카오뱅크")) {
                        Discount affiliateDiscount = new AffiliateDiscount(null);
                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
                    }
                }

                if (telecomCheckBox.isSelected()) {
                    String telecomOption = (String) telecomComboBox.getSelectedItem();
                    if (telecomOption.equals("KT")) {
                        Discount telecomDiscount = new TelecomDiscount(null);
                        discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
                    } else if (telecomOption.equals("SKT")) {
                         Discount telecomDiscount = new TelecomDiscount(null);
                        discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
                    } else if (telecomOption.equals("LG U+")) {
                         Discount telecomDiscount = new TelecomDiscount(null);
                        discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
                    }
                }

                if (cashCheckBox.isSelected()) {
                    double point = Double.parseDouble(cashTextField.getText());
                    Discount pointDiscount = new CashDiscount(null, point);
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
