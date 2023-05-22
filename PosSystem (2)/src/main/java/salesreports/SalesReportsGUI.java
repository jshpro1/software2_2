
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salesreports;

/**
 *
 * @author jsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesReportsGUI extends JFrame {

    private List<Sale> sales;
    private JTextField monthTextField;
    private JTextField weekTextField;
    private JTextField dayTextField;
    private JTextField resultTextField;

    public SalesReportsGUI(List<Sale> sales) {
        this.sales = sales;

        setTitle("매출 통계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel yearLabel = new JLabel("2023년");
        topPanel.add(yearLabel);

        JLabel label = new JLabel("매출 통계 선택:");
        topPanel.add(label);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("일일 매출액");
        comboBox.addItem("주간 매출액");
        comboBox.addItem("월간 매출액");
        comboBox.addItem("전체 매출액");
        topPanel.add(comboBox);

        JLabel monthLabel = new JLabel("월:");
        monthTextField = new JTextField(2);
        monthTextField.setEnabled(false); // 기본적으로 비활성화
        JLabel weekLabel = new JLabel("주:");
        weekTextField = new JTextField(2);
        weekTextField.setEnabled(false); // 기본적으로 비활성화
        JLabel dayLabel = new JLabel("일:");
        dayTextField = new JTextField(2);
        dayTextField.setEnabled(false); // 기본적으로 비활성화

        topPanel.add(monthLabel);
        topPanel.add(monthTextField);
        topPanel.add(weekLabel);
        topPanel.add(weekTextField);
        topPanel.add(dayLabel);
        topPanel.add(dayTextField);

        JButton button = new JButton("조회");
        topPanel.add(button);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                // 선택한 옵션에 따라 텍스트 필드 활성화 여부 설정
                switch (selectedOption) {
                    case "일일 매출액":
                        monthTextField.setEnabled(true);
                        dayTextField.setEnabled(true);
                        weekTextField.setEnabled(false);
                        break;
                    case "주간 매출액":
                        monthTextField.setEnabled(true);
                        weekTextField.setEnabled(true);
                        dayTextField.setEnabled(false);
                        break;
                    case "월간 매출액":
                        monthTextField.setEnabled(true);
                        weekTextField.setEnabled(false);
                        dayTextField.setEnabled(false);
                        break;
                    default:
                        monthTextField.setEnabled(false);
                        weekTextField.setEnabled(false);
                        dayTextField.setEnabled(false);
                        break;
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                int salesAmount = calculateSales(selectedOption);
                resultTextField.setText(Integer.toString(salesAmount));
            }
        });

        panel.add(topPanel, BorderLayout.NORTH);

        resultTextField = new JTextField();
        resultTextField.setEditable(false);
        resultTextField.setHorizontalAlignment(JTextField.CENTER);
        Font font = new Font("Arial", Font.BOLD, 20);
        resultTextField.setFont(font);
        panel.add(resultTextField, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private int calculateSales(String selectedOption) {
        SalesCalculator salesCalculator;
        switch (selectedOption) {
            case "일일 매출액":
                int inputMonth1 = Integer.parseInt(monthTextField.getText());
                int inputDay = Integer.parseInt(dayTextField.getText());
                salesCalculator = new SalesCalculator(new DailySalesCalculation(inputMonth1, inputDay));
                return salesCalculator.calculateSales(sales);
            case "주간 매출액":
                int inputMonth2 = Integer.parseInt(monthTextField.getText());
                int inputWeek = Integer.parseInt(weekTextField.getText());
                salesCalculator = new SalesCalculator(new WeeklySalesCalculation(inputMonth2, inputWeek));
                return salesCalculator.calculateSales(sales);
            case "월간 매출액":
                int inputMonth3 = Integer.parseInt(monthTextField.getText());
                salesCalculator = new SalesCalculator(new MonthlySalesCalculation(inputMonth3));
                return salesCalculator.calculateSales(sales);
            case "전체 매출액":
                return sales.stream().mapToInt(Sale::getTotalPrice).sum();
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = readSalesFromFile("sales.txt");
        SwingUtilities.invokeLater(() -> new SalesReportsGUI(sales));
    }

    private static List<Sale> readSalesFromFile(String filePath) {
        List<Sale> sales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String itemName = tokens[0];
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[1]);
                int itemPrice = Integer.parseInt(tokens[2]);
                int quantity = Integer.parseInt(tokens[3]);
                Sale sale = new Sale(date, itemName, itemPrice, quantity);
                sales.add(sale);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return sales;
    }
}

