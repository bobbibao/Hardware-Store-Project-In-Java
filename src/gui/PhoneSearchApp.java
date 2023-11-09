package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneSearchApp {
    private JFrame frame;
    private JTextField searchField;
    private JPanel resultPanel;
    private JTextArea resultArea;
    private ArrayList<String> phoneList;
    private Map<String, String> phoneNameMap;

    public PhoneSearchApp() {
        frame = new JFrame("Phone Search App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        phoneList = new ArrayList<>();
        phoneList.add("1234567890");
        phoneList.add("9876543210");
        phoneList.add("5551234567");
        phoneList.add("9998887777");
        phoneList.add("7777777777");

        phoneNameMap = new HashMap<>();
        phoneNameMap.put("1234567890", "Alice");
        phoneNameMap.put("9876543210", "Bob");
        phoneNameMap.put("5551234567", "Charlie");
        phoneNameMap.put("9998887777", "David");
        phoneNameMap.put("7777777777", "Eve");

        JPanel mainPanel = new JPanel(new BorderLayout());

        searchField = new JTextField();
        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Chạy tìm kiếm khi có ký tự mới được nhập
                performSearch(searchField.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        resultPanel = new JPanel(new BorderLayout());
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        resultPanel.add(resultArea, BorderLayout.CENTER);

        mainPanel.add(searchField, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
    }

    private void performSearch(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            resultPanel.setVisible(false); // Ẩn giao diện kết quả khi không có dữ liệu tìm kiếm
        } else {
            resultArea.setText(""); // Xóa kết quả trước đó
            resultPanel.setVisible(true); // Hiện giao diện kết quả khi có dữ liệu tìm kiếm

            for (String number : phoneList) {
                if (number.contains(phoneNumber)) {
                    String name = phoneNameMap.get(number);
                    resultArea.append(name + ": " + number + "\n");
                }
            }
        }
    }

    public void display() {
        resultPanel.setVisible(false); // Ẩn giao diện kết quả khi ban đầu
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PhoneSearchApp app = new PhoneSearchApp();
        app.display();
    }
}
