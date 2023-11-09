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
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.ScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import entity.nhaCungCap;

import javax.swing.JScrollPane;




public class Nhacungcap extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private DefaultTableModel modelNCC;
	private JTable tablemodelNCC;
	private DefaultTableModel tablemodel1;
	
	

	
	//khai bao DAO
	NhaCungCap_DAO ncc_dao;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhacungcap frame = new Nhacungcap();
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
	public Nhacungcap() {
		
		//ket noi data base
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		//khoi tao dao
		
		ncc_dao=new NhaCungCap_DAO();
		
		setResizable(false);
		setTitle("Hóa Đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 87, 474, 551);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã NCC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 29, 120, 34);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 39, 234, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnNcc = new JLabel("Tên NCC");
		lblTnNcc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnNcc.setBounds(21, 93, 120, 34);
		panel.add(lblTnNcc);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 114, 234, 19);
		panel.add(textField_1);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi.setBounds(21, 174, 120, 34);
		panel.add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(21, 248, 120, 34);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 184, 234, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(201, 258, 234, 19);
		panel.add(textField_3);
		
		JLabel lblaCh = new JLabel("Địa chỉ ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(21, 345, 120, 34);
		panel.add(lblaCh);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 355, 234, 19);
		panel.add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 408, 443, 133);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_3.getText().equals("")
						||textField_4.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin");
					
				}else {
					nhaCungCap ncc=revertNhanVienformtxt();
					ncc_dao.addNCC(ncc);
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					xoatrang();
					
				}	
			}
		});
		btnNewButton.setBounds(10, 24, 104, 33);
		panel_1.add(btnNewButton);
		
		JButton btnNewButto = new JButton("Xóa");
		btnNewButto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r =table.getSelectedRow();
				if(r>=0) {
					String ma=tablemodel1.getValueAt(r, 0).toString();
					int hoi=JOptionPane.showConfirmDialog(null, "Ban chac chan muon xoa dong nay","Yes",JOptionPane.YES_OPTION);
					if(hoi==JOptionPane.YES_OPTION) {
						ncc_dao.deleteNCC(ma);
						tablemodel1.removeRow(r); // xóa trong table model
					}
				}
			}
		});
		btnNewButto.setBounds(10, 90, 104, 33);
		panel_1.add(btnNewButto);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_3.getText().equals("")
						||textField_4.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin");
					
				}else {
					nhaCungCap ncc=revertNhanVienformtxt();
					ncc_dao.updateNCC(ncc);
					XoadulieuTablemodel();
					DocdulieudatabasevaoTable();
					xoatrang();
					
				
					
					
					
					
			}
				}
		});

		btnSa.setBounds(299, 24, 104, 33);
		panel_1.add(btnSa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoatrang();
			}
		});
		btnReset.setBounds(299, 90, 104, 33);
		panel_1.add(btnReset);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 648, 1213, 73);
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
		panel_5.setBounds(541, 10, 248, 64);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel_5.setForeground(new Color(0, 128, 255));
		lblNewLabel_5.setBounds(57, 10, 204, 49);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(494, 94, 729, 544);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 729, 544);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(tablemodel1=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 NCC", "T\u00EAn NCC ", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "\u0110\u1ECBa ch\u1EC9 "
			}
	));
		//doc du lieu tu sql vao table
		DocdulieudatabasevaoTable();
		
		//sukien
		table.addMouseListener(this);
		
		
		
		
		
		
}
	private entity.nhaCungCap revertNhanVienformtxt() {
		String ma=textField.getText();
		String ten=textField_1.getText();
		String soDienThoai=textField_2.getText();
		String email=textField_3.getText();
		String diaChi=textField_4.getText();
		return new nhaCungCap(ma, ten, soDienThoai, email, diaChi);
	}
	public void XoadulieuTablemodel() {
		while (table.getRowCount()>0) {
			tablemodel1.removeRow(0);
		}
	}
	//doc du lieu tu database
	public void DocdulieudatabasevaoTable() {
		List<nhaCungCap> list=ncc_dao.getalltbNhaCungCap();
		for (nhaCungCap nhaCungCap : list) {
			tablemodel1.addRow(new Object[] {nhaCungCap.getMaNCC(),nhaCungCap.getTenNCC(),nhaCungCap.getSoDienThoai(),nhaCungCap.getEmail(),nhaCungCap.getDiaChi()});
		}
		
	}
	
	//hover button
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
	
	//ham tao anh
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		textField.setText(tablemodel1.getValueAt(row, 0).toString());
		textField_1.setText(tablemodel1.getValueAt(row, 1).toString());
		textField_2.setText(tablemodel1.getValueAt(row, 2).toString());
		textField_3.setText(tablemodel1.getValueAt(row, 3).toString());
		textField_4.setText(tablemodel1.getValueAt(row, 4).toString());
		textField.setEditable(false);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void xoatrang() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField.requestFocus();
	}
	
	
}
