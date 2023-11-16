package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.KhachHang;

public class GD_KhachHang extends GD_Layout{

	public GD_KhachHang() {
		super("Quản Lý Khách Hàng");
		// TODO Auto-generated constructor stub
	}

	@Override
	public JPanel mainUI() {
		
		    JPanel main = new JPanel();
		    main.setLayout(new GridBagLayout());
		    GridBagConstraints gbc = new GridBagConstraints();

		    main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		    main.setBorder(BorderFactory.createTitledBorder("Quản lí khách hàng"));
		     // Use a null layout for topPanel
		   // Change the background color
		    main.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    

		    JPanel topPanel = new JPanel();
		    topPanel.setLayout(null); // Use a null layout for topPanel
		    topPanel.setBackground(Color.BLACK); // Change the background color
		    

		    // Create and add a JLabel and a JTextField for search
		    JLabel searchLabel = new JLabel("Tìm kiếm :");
		    searchLabel.setBounds(10, 10, 80, 25); // Set bounds for the label
		    topPanel.add(searchLabel);
		    searchLabel.setForeground(Color.PINK);
		    

		    JTextField searchTextField = new JTextField();
		    searchTextField.setBounds(70, 10,300, 25); // Set bounds for the text field
		    topPanel.add(searchTextField);
		    searchTextField.setBackground(Color.BLACK); // Set background color to black
		    searchTextField.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    searchTextField.setForeground(Color.PINK);
		    
		    JLabel label1 = new JLabel("Họ Tên :");
		    label1.setBounds(10, 50, 80, 25);
		    topPanel.add(label1);
		    label1.setForeground(Color.PINK);

		    JTextField textField1 = new JTextField();
		    textField1.setBounds(70, 50, 150, 25);
		    topPanel.add(textField1);
		    textField1.setBackground(Color.BLACK); // Set background color to black
		    textField1.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField1.setForeground(Color.PINK);
		   

		    JLabel label2 = new JLabel("Số điện thoại :");
		    label2.setBounds(1, 90, 80, 25);
		    topPanel.add(label2);
		    label2.setForeground(Color.PINK);
		    

		    JTextField textField2 = new JTextField();
		    textField2.setBounds(90, 90, 130, 25);
		    topPanel.add(textField2);
		    textField2.setBackground(Color.BLACK); // Set background color to black
		    textField2.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField2.setForeground(Color.PINK);
		    
		    

		    JLabel label3 = new JLabel("Giới tính:");
		    label3.setBounds(240, 50, 80, 25);
		    topPanel.add(label3);
		    label3.setForeground(Color.PINK);

		    JTextField textField3 = new JTextField();
		    textField3.setBounds(305, 50, 150, 25);
		    topPanel.add(textField3);
		    textField3.setBackground(Color.BLACK); // Set background color to black
		    textField3.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField3.setForeground(Color.PINK);

		    JLabel label4 = new JLabel("Địa Chỉ :");
		    label4.setBounds(240, 90, 80, 25);
		    topPanel.add(label4);
		    label4.setForeground(Color.PINK);

		    JTextField textField4 = new JTextField();
		    textField4.setBounds(305, 90, 150, 25);
		    topPanel.add(textField4);
		    textField4.setBackground(Color.BLACK); // Set background color to black
		    textField4.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField4.setForeground(Color.PINK);

		    JLabel label5 = new JLabel("Email :");
		    label5.setBounds(470, 50, 80, 25);
		    topPanel.add(label5);
		    label5.setForeground(Color.PINK);
		    
		    JTextField textField5 = new JTextField();
		    textField5.setBounds(535, 50, 150, 25);
		    topPanel.add(textField5);
		    textField5.setBackground(Color.BLACK); // Set background color to black
		    textField5.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField5.setForeground(Color.PINK);

		    JLabel label6 = new JLabel("Điểm TL :");
		    label6.setBounds(470, 90, 80, 25);
		    topPanel.add(label6);
		    label6.setForeground(Color.PINK);
		    
		    JTextField textField6 = new JTextField();
		    textField6.setBounds(535, 90, 150, 25);
		    topPanel.add(textField6);
		    textField6.setBackground(Color.BLACK); // Set background color to black
		    textField6.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    textField6.setForeground(Color.PINK);

		    // Create and add three buttons
		    JButton button1 = new JButton("Thêm");
		    button1.setBounds(900, 45, 80, 30); // Set bounds for the button
		    topPanel.add(button1);
		    button1.setBackground(Color.BLACK); // Set background color to black
		    button1.setForeground(Color.PINK);
		    button1.setBorder(BorderFactory.createLineBorder(Color.PINK));

		    JButton button2 = new JButton("Xóa");
		    button2.setBounds(810,	45, 80, 30); // Set bounds for the button
		    topPanel.add(button2);
		    button2.setBackground(Color.BLACK); // Set background color to black
		    button2.setForeground(Color.PINK);
		    button2.setBorder(BorderFactory.createLineBorder(Color.PINK));

		    JButton button3 = new JButton("Sửa");
		    button3.setBounds(900, 85 , 80, 30); // Set bounds for the button
		    topPanel.add(button3);
		    button3.setBackground(Color.BLACK); // Set background color to black
		    button3.setForeground(Color.PINK);button3.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    
		    JButton button4 = new JButton(" 4");
		    button4.setBounds(810, 85, 80, 30); // Set bounds for the button
		    topPanel.add(button4);
		    button4.setBackground(Color.BLACK); // Set background color to black
		    button4.setForeground(Color.PINK);button4.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    
		    JButton button5 = new JButton(" 5");
		    button5.setBounds	(720,45 , 80, 30); // Set bounds for the button
		    topPanel.add(button5);
		    button5.setBackground(Color.BLACK); // Set background color to black
		    button5.setForeground(Color.PINK);
		    button5.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    
		    JButton button6 = new JButton(" 6");
		    button6.setBounds(720,85 , 80, 30); // Set bounds for the button
		    topPanel.add(button6);
		    button6.setBackground(Color.BLACK); // Set background color to black
		    button6.setForeground(Color.PINK);button6.setBorder(BorderFactory.createLineBorder(Color.PINK));
		    
		    
		    
		    
		    

		    // Set the layout for the topPanel
		    gbc.fill = GridBagConstraints.BOTH;
		    gbc.weightx = 1;
		    gbc.weighty = 0.7; // 30% for topPanel
		    main.add(topPanel, gbc);

		    JPanel bottomPane2 = new JPanel();
		    bottomPane2.setLayout(new GridBagLayout());
		   
		    bottomPane2.setBackground(Color.BLACK); // Change the background color
		    TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.PINK), "Danh sách Khách Hàng");
		    titledBorder.setTitleColor(Color.PINK);
		    titledBorder.setTitleFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		    bottomPane2.setBorder(titledBorder);

		    // Set the GridBagConstraints for bottomPane2
		    gbc.gridy = 1;
		    gbc.weighty = 0.1; // 70% for bottomPane2
		    main.add(bottomPane2, gbc);
		    
		    List<KhachHang> kh = new ArrayList<>();
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    kh.add(new KhachHang("Pham Van A","0987654","Nam","dfsdfsd@gmial.com",1000,"ádas")); 
		    
		    // Add more employees here...

		    // Create column names and data for the table
		    String[] columnNames = {"Họ Tên","Số Điện Thoại", "Giới Tính", "Địa Chỉ", "Email", "Điểm Tích Lũy"};
		    Object[][] data = new Object[kh.size()][columnNames.length];

		    for (int i = 0; i < kh.size(); i++) {
		        data[i] = new Object[]{
		          
		        };
		    }

		    // Create a DefaultTableModel with the data
		    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
		    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	        cellRenderer.setBackground(Color.BLACK);
	        cellRenderer.setForeground(Color.PINK);

		    // Create the JTable with the DefaultTableModel
		    JTable employeeTable = new JTable(tableModel);
		    employeeTable.setBackground(Color.BLACK);
	        employeeTable.setForeground(Color.PINK);
	        employeeTable.setBorder(BorderFactory.createLineBorder(Color.PINK));
	        JTableHeader tableHeader = employeeTable.getTableHeader();
	        tableHeader.setBackground(Color.BLACK);
	        tableHeader.setForeground(Color.PINK);
	        tableHeader.setBorder(BorderFactory.createLineBorder(Color.PINK));

	        // Set the background color for the selected cell
	        employeeTable.setSelectionBackground(Color.PINK);

		    // Add the JTable to a JScrollPane to enable scrolling if needed
		    JScrollPane tableScrollPane = new JScrollPane(employeeTable);

		    // Add the JScrollPane to the bottomPane2
		    
		    bottomPane2.add(tableScrollPane, gbc);
		
		  
		    return main;
		}
public static void main(String[] args) {
	 new GD_KhachHang().setVisible(true);
}
}
