package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Hoadon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hoadon frame = new Hoadon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hoadon() {
		setResizable(false);
		setTitle("Hóa Đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1352, 768);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 87, 352, 551);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập từ khóa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 26, 228, 31);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 332, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn loại sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 116, 228, 31);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 157, 332, 39);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 332, 335);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 LK", "T\u00EAn LK", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(372, 87, 966, 209);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(21, 34, 99, 13);
		panel_1.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBorder(null);
		textField_4.setBounds(173, 33, 96, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ngày lập hóa đơn");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(21, 81, 130, 18);
		panel_1.add(lblNewLabel_4_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBorder(null);

		textField_5.setColumns(10);
		textField_5.setBounds(173, 80, 96, 19);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(21, 141, 130, 18);
		panel_1.add(lblNewLabel_4_1_1);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBorder(null);

		textField_6.setBounds(173, 143, 96, 19);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Chọn khách hàng");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1_2.setBounds(510, 31, 130, 18);
		panel_1.add(lblNewLabel_4_1_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(705, 32, 228, 21);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Thông tin khách hàng ");
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1_2_1.setBounds(510, 81, 168, 18);
		panel_1.add(lblNewLabel_4_1_2_1);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBorder(null);

		textField_8.setBounds(705, 83, 228, 19);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(372, 306, 966, 183);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 966, 183);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn LK", "SL", "Gi\u00E1 b\u00E1n", "Th\u00E0nh ti\u1EC1n", "Ghi ch\u00FA "
			}
		));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EF1 ki\u1EC7n h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(372, 499, 966, 139);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Hủy");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(716, 96, 104, 33);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thanh Toán");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(830, 96, 104, 33);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Tổng tiền");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 27, 84, 45);
		panel_3.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);

		textField_1.setEditable(false);
		textField_1.setBounds(92, 42, 133, 19);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tiền khách trả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(309, 39, 115, 21);
		panel_3.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(null);

		textField_2.setColumns(10);
		textField_2.setBounds(441, 42, 133, 19);
		panel_3.add(textField_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tiền trả khách");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(637, 39, 115, 21);
		panel_3.add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);

		textField_3.setForeground(Color.BLUE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(774, 42, 133, 19);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 648, 1328, 73);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnNewButton_2_5_5 = new JButton("BÁN HÀNG F1");
		btnNewButton_2_5_5.addMouseListener(createHoverEffect(btnNewButton_2_5_5));
		panel_4.add(btnNewButton_2_5_5);
		
		JButton btnNewButton_2_5_5_1 = new JButton("SẢN PHẨM F2");
		btnNewButton_2_5_5_1.addMouseListener(createHoverEffect(btnNewButton_2_5_5_1));
		panel_4.add(btnNewButton_2_5_5_1);
		
		JButton btnNewButton_2_5_5_2 = new JButton("KHÁCH HÀNG F3");
		btnNewButton_2_5_5_2.addMouseListener(createHoverEffect(btnNewButton_2_5_5_2));
		panel_4.add(btnNewButton_2_5_5_2);
		
		JButton btnNewButton_2_5_5_3 = new JButton("NHÂN VIÊN F4");
		btnNewButton_2_5_5_3.addMouseListener(createHoverEffect(btnNewButton_2_5_5_3));
		panel_4.add(btnNewButton_2_5_5_3);
		
		JButton btnNewButton_2_5_5_4 = new JButton("THỐNG KÊ F5");
		btnNewButton_2_5_5_4.addMouseListener(createHoverEffect(btnNewButton_2_5_5_4));
		panel_4.add(btnNewButton_2_5_5_4);
		
		JButton btnNewButton_2_5_5_5 = new JButton("HÓA ĐƠN F6");
		btnNewButton_2_5_5_5.addMouseListener(createHoverEffect(btnNewButton_2_5_5_5));
		panel_4.add(btnNewButton_2_5_5_5);
		
		JButton btnNewButton_2_5_5_6 = new JButton("NHÀ CUNG CẤP F7");
		btnNewButton_2_5_5_6.addMouseListener(createHoverEffect(btnNewButton_2_5_5_6));
		panel_4.add(btnNewButton_2_5_5_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(603, 10, 248, 64);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("HÓA ĐƠN");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setBounds(83, 10, 93, 49);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_5);
		
		
		
		
		
	}
	private MouseAdapter createHoverEffect(JButton btn) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(41, 128, 185)); // Change background color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(52, 152, 219)); // Restore original background color
            }
        };
    }
	private Image createImage(String imagePath, int width, int height) {
		 try {
			BufferedImage originalImage = ImageIO.read(new FileInputStream(imagePath));
	        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = resizedImg.createGraphics();
	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2.drawImage(originalImage, 0, 0, width, height, null);
	        g2.dispose();
	        return resizedImg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   }
	
}
