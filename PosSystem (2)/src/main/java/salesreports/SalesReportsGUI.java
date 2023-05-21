
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
    private JTextField textField;
    private JTextField monthTextField;
    private JTextField weekTextField;

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

        JLabel label = new JLabel("매출 통계 선택:");
        topPanel.add(label);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("일일 매출액");
        comboBox.addItem("주간 매출액");
        comboBox.addItem("월간 매출액");
        comboBox.addItem("전체 매출액");
        topPanel.add(comboBox);

        monthTextField = new JTextField(5);
        topPanel.add(monthTextField);

        JLabel monthLabel = new JLabel("월");
        topPanel.add(monthLabel);

        weekTextField = new JTextField(5);
        topPanel.add(weekTextField);

        JLabel weekLabel = new JLabel("주");
        topPanel.add(weekLabel);

        JButton button = new JButton("조회");
        topPanel.add(button);

        panel.add(topPanel, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        Font font = new Font("Arial", Font.BOLD, 20);
        textField.setFont(font);
        panel.add(textField, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                int salesAmount = calculateSales(selectedOption);
                textField.setText(Integer.toString(salesAmount));
            }
        });

        add(panel);
        setVisible(true);
    }

    private int calculateSales(String selectedOption) {
        SalesCalculator salesCalculator;
        switch (selectedOption) {
            case "일일 매출액":
                salesCalculator = new SalesCalculator(new DailySalesCalculation());
                return salesCalculator.calculateSales(sales);
            case "주간 매출액":
                int selectedMonth = Integer.parseInt(monthTextField.getText());
                int selectedWeek = Integer.parseInt(weekTextField.getText());
                salesCalculator = new SalesCalculator(new WeeklySalesCalculation(selectedMonth, selectedWeek));
                return salesCalculator.calculateSales(sales);
            case "월간 매출액":
                int inputMonth = Integer.parseInt(monthTextField.getText());
                salesCalculator = new SalesCalculator(new MonthlySalesCalculation(inputMonth));
                return salesCalculator.calculateSales(sales);
            case "전체 매출액":
                return sales.stream().mapToInt(Sale::getTotalPrice).sum();
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        // sales.txt 파일에서 데이터를 읽어온 후 SalesReportsGUI를 생성하여 GUI를 실행합니다.
        List<Sale> sales = readSalesFromFile("sales.txt");
        SwingUtilities.invokeLater(() -> new SalesReportsGUI(sales));
    }

    private static List<Sale> readSalesFromFile(String fileName) {
        // 파일에서 데이터를 읽어와서 Sale 객체의 리스트를 생성합니다.
        // 이 부분은 기존의 코드와 동일합니다.
        List<Sale> sales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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
