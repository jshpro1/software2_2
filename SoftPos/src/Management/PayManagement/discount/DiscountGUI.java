/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Management.PayManagement.discount;

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
    private JTextField discountedPriceTextField; // 할인된 가격을 보여주는 텍스트 필드
    private JTextField discountAmountTextField;
    private JButton applyButton;
    private JCheckBox affiliateCheckBox;
    private JComboBox<String> affiliateComboBox;
    private JCheckBox telecomCheckBox;
    private JComboBox<String> telecomComboBox;
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
        String[] affiliateOptions = {"우리은행", "국민은행", "토스뱅크", "카카오뱅크"};
        affiliateComboBox = new JComboBox<>(affiliateOptions);
        affiliateComboBox.setEnabled(false);
        affiliatePanel.add(affiliateCheckBox);
        affiliatePanel.add(affiliateComboBox);

        JPanel telecomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        telecomCheckBox = new JCheckBox("통신사 할인");
        String[] telecomOptions = {"KT", "SKT", "LGU+"};
        telecomComboBox = new JComboBox<>(telecomOptions);
        telecomComboBox.setEnabled(false);
        telecomPanel.add(telecomCheckBox);
        telecomPanel.add(telecomComboBox);

        JPanel pointPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cashCheckBox = new JCheckBox("현금 할인");
        cashTextField = new JTextField(10);
        cashTextField.setEnabled(false);
        pointPanel.add(cashCheckBox);
        JLabel pointLabel = new JLabel("할인금액을 입력하세요 : ");
        pointPanel.add(pointLabel);
        pointPanel.add(cashTextField);

        JPanel discountPricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel discountPriceLabel = new JLabel("할인된 가격: ");
        discountedPriceTextField = new JTextField(10);
        discountPricePanel.add(discountPriceLabel);
        discountedPriceTextField.setEditable(false);
        discountPricePanel.add(discountedPriceTextField);

        JPanel discountAmountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel discountAmountLabel = new JLabel("할인 금액: ");
        discountAmountTextField = new JTextField(10);
        discountAmountTextField.setEditable(false);
        discountAmountPanel.add(discountAmountLabel);
        discountAmountPanel.add(discountAmountTextField);

        discountPanel.add(affiliatePanel);
        discountPanel.add(telecomPanel);
        discountPanel.add(pointPanel);
        discountPanel.add(discountPricePanel);
        discountPanel.add(discountAmountPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(discountPanel, BorderLayout.CENTER);

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
                int price = Integer.parseInt(priceTextField.getText());
                int discountedPrice = price;
                Discount d1 = new BaseDiscount(price);

//                if (affiliateCheckBox.isSelected()) {
//                    String affiliateOption = (String) affiliateComboBox.getSelectedItem();
//                    if (affiliateOption.equals("우리은행")) {
//                        Discount affiliateDiscount = new AffiliateDiscount(null);
//                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
//                    } else if (affiliateOption.equals("국민은행")) {
//                        Discount affiliateDiscount = new AffiliateDiscount(null);
//                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
//                    } else if (affiliateOption.equals("토스은행")) {
//                        Discount affiliateDiscount = new AffiliateDiscount(null);
//                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
//                    } else if (affiliateOption.equals("카카오뱅크")) {
//                        Discount affiliateDiscount = new AffiliateDiscount(null);
//                        discountedPrice = affiliateDiscount.applyDiscount(discountedPrice);
//                    }
//                }
                if (affiliateCheckBox.isSelected()) {
                    d1 = new AffiliateDiscount(d1, (String) affiliateComboBox.getSelectedItem());
                    

                }
                if (telecomCheckBox.isSelected()) {
                    d1 = new TelecomDiscount(d1, (String) telecomComboBox.getSelectedItem());

                }
//                    if (telecomCheckBox.isSelected()) {
//                        String telecomOption = (String) telecomComboBox.getSelectedItem();
//                        if (telecomOption.equals("KT")) {
//                            Discount telecomDiscount = new TelecomDiscount(null);
//                            discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
//                        } else if (telecomOption.equals("SKT")) {
//                            Discount telecomDiscount = new TelecomDiscount(null);
//                            discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
//                        } else if (telecomOption.equals("LG U+")) {
//                            Discount telecomDiscount = new TelecomDiscount(null);
//                            discountedPrice = telecomDiscount.applyDiscount(discountedPrice);
//                        }
//                    }

//                if (cashCheckBox.isSelected()) {
//                    double point = Double.parseDouble(cashTextField.getText());
//                    Discount pointDiscount = new CashDiscount(null, point);
//                    discountedPrice = pointDiscount.applyDiscount(discountedPrice);
//                }
//                discountedPriceTextField.setText(String.valueOf(discountedPrice));
//복구할거
                discountedPriceTextField.setText(String.valueOf(d1.applyDiscount()));
                discountAmountTextField.setText(String.valueOf(price - d1.applyDiscount()));

                double discountAmount = price - discountedPrice;
//                discountAmountTextField.setText(String.valueOf(discountAmount));
            }
        }
        );
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
