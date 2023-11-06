package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class Inventory extends JFrame{
	private static final long serialVersionUID = 1L;
    private int currentPage = 1;
    private int itemsPerPage = 15;
    private int totalProducts = 100;
    private int totalPages= (int) Math.ceil((double) totalProducts / itemsPerPage);;
	private JLabel btnPage1, btnPage2, btnPage3, btnPage4, btnPage5, btnPage6, btnPage7;
	private JCheckBox isActive;
	private JButton prevButton;
	private JButton nextButton;
	public Inventory() {
		super("Products");
		setSize(1400, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pMenu = menuUI();
		JPanel toolbar = toolbarUI();
		JPanel main = mainUI();
		JPanel sidebar = sidebarUI();
		ImageIcon bg = new ImageIcon(createImage("img/products/UI.png", 1400, 1000));
		JLabel bgi = new JLabel(bg);
		this.add(bgi);
		this.add(main);
		this.add(pMenu, BorderLayout.SOUTH);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(sidebar, BorderLayout.WEST);
		
	}
	public Box createProductCard(int i) {
		String imagePath = "img/products/UI.png";
		Box productCard;
		productCard = Box.createVerticalBox();
        JPanel p1, p2, p3;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        JLabel lblProductName = new JLabel("Sản Phẩm " + i);
        lblProductName.setFont(new Font(Font.SANS_SERIF, 10, 14));
        ImageIcon productImage = new ImageIcon(createImage(imagePath, 200, 140));
        JLabel imageLabel = new JLabel(productImage);
        
        JLabel btnAdd = new JLabel("#Ma san pham");
        btnAdd.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
        productCard.add(p1);
        productCard.add(p2);
        productCard.add(p3);
        p1.add(imageLabel);
        p2.add(lblProductName);
        p1.setPreferredSize(new Dimension(100, 118));
        p2.setPreferredSize(new Dimension(100, 15));
        p3.setPreferredSize(new Dimension(100, 15));
        p3.add(btnAdd);
        return productCard;
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

	private void addProductCards(JPanel main) {
        int start = (currentPage - 1) * itemsPerPage + 1;
        int end = start + itemsPerPage - 1;

        main.removeAll();

        for (int i = start; i <= end; i++) {
            if (i <= 100) { // Replace 10 with the total number of products
                Box productCard = createProductCard(i);
                productCard.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                main.add(productCard);
            }
        }

        main.revalidate();
        main.repaint();
    }
	public JPanel toolbarUI() {
		JPanel toolbar = new JPanel(new BorderLayout());
		JPanel title = new JPanel();
		JPanel titleside = new JPanel();
		JPanel imageuser = new JPanel();
		JPanel groupContainer = new JPanel(new BorderLayout());
		Box userContainer, userRight;
		userContainer = Box.createHorizontalBox();
		userRight = Box.createVerticalBox();
		
		groupContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Box b = Box.createHorizontalBox();
		b.setPreferredSize(new Dimension(100, 30));
		JPanel group = new JPanel() {
		     @Override
		     protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Dimension arcs = new Dimension(40,40);
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		        //Draws the rounded opaque panel with borders.
		        graphics.setColor(getBackground());
		        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		        graphics.setColor(getForeground());
		        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		     }
		  };

		JLabel titlelbl = new JLabel("SẢN PHẨM");
		titlelbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		ImageIcon imageIcon = new ImageIcon(createImage("img/icons/left-arrow.png", 30, 30));
		JLabel titleicon = new JLabel(imageIcon);
		ImageIcon helpIcon = new ImageIcon(createImage("img/icons/help.png", 30, 30));
		JLabel helpicon = new JLabel(helpIcon);
		ImageIcon wishlistIcon = new ImageIcon(createImage("img/icons/wishlist.png", 25, 25));
		JLabel wishlisticon = new JLabel(wishlistIcon);
		ImageIcon addIcon = new ImageIcon(createImage("img/icons/add.png", 30, 30));
		JLabel addicon = new JLabel(addIcon);
		ImageIcon editIcon = new ImageIcon(createImage("img/icons/edit.png", 30, 30));
		JLabel editicon = new JLabel(editIcon);
		ImageIcon userImage = new ImageIcon(createImage("img/icons/user.png", 30, 30));
		JLabel userimage = new JLabel(userImage);
		String html = "<html><div align='right'>Nhóm 10</div></html>";
        JLabel username = new JLabel(html);
		JLabel position = new JLabel("<html><div align='right'>Quản lý</div></html>", SwingConstants.RIGHT);
		
		editicon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		addicon.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 10));
		CustomSeparator separator = new CustomSeparator(Color.black, 1, 20);
		CustomSeparator separator2 = new CustomSeparator(Color.black, 1, 40);
		titleside.add(helpicon);
		titleside.add(separator);
		titleside.add(wishlisticon);
		titleside.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 210));
		title.add(titleicon);
		title.add(titlelbl);
		title.add(titleside);
		
		b.add(editicon,Box.CENTER_ALIGNMENT);
		b.add(Box.createHorizontalGlue());
		b.add(addicon);
		group.add(b);
		groupContainer.add(group, BorderLayout.WEST);
		userContainer.add(userRight);
		userContainer.add(Box.createHorizontalStrut(10));
		userContainer.add(imageuser.add(userimage));
		userContainer.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 20));
		userRight.add(username);
		userRight.add(position);
		toolbar.add(userContainer, BorderLayout.EAST);
		toolbar.add(title, BorderLayout.WEST);
		toolbar.add(groupContainer);
		toolbar.setPreferredSize(new Dimension(150, 50));
		return toolbar;
	}
	public JPanel mainUI() {
		JPanel mainUI = new JPanel(new BorderLayout());
		JPanel productContainer = new JPanel(new GridLayout(3, 5, 20, 20));
		JPanel pag = new JPanel();
		Box toolbar, barleft, barright;
		toolbar = Box.createHorizontalBox();
		barleft = Box.createHorizontalBox();
		barright = Box.createHorizontalBox();
        mainUI.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // Add padding
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        JTextField pagination = BTextField();
     // Load the image
        ImageIcon allIcon = new ImageIcon(createImage("img/icons/all.png", 30, 30));
        JButton allLabel = new JButton(allIcon);
        allLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon mouseIcon = new ImageIcon(createImage("img/icons/keyboard.png", 30, 30));
        JButton mousebtn = new JButton(mouseIcon);
        mousebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon keyboardIcon = new ImageIcon(createImage("img/icons/mouse.png", 30, 30));
        JButton keyboardLabel = new JButton(keyboardIcon);
        keyboardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon monitorIcon = new ImageIcon(createImage("img/icons/monitor.png", 30, 30));
        JButton monitorLabel = new JButton(monitorIcon);
        monitorLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon loupeIcon = new ImageIcon(createImage("img/icons/loupe.png", 20, 20));
        JButton loupeLabel = new JButton(loupeIcon);
        loupeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        String sorting[] = {"Sắp Xếp Mặc Định", "Theo Tên", "Theo Mã Sản Phẩm", "Theo Ngày Thêm", "Theo Đơn Giá"};
        isActive = new JCheckBox("ĐÃ NGỪNG BÁN");
        JComboBox<String> cb = new JComboBox<String>(sorting);
        barleft.add(allLabel);
        barleft.add(Box.createHorizontalStrut(10));
        barleft.add(mousebtn);
        barleft.add(Box.createHorizontalStrut(10));
        barleft.add(keyboardLabel);
        barleft.add(Box.createHorizontalStrut(10));
        barleft.add(monitorLabel);
        barright.add(isActive);
        barright.add(Box.createHorizontalStrut(10));
        barright.add(loupeLabel);
        barright.add(Box.createHorizontalStrut(10));
        barright.add(cb);
        toolbar.add(barleft);
        toolbar.add(Box.createHorizontalStrut(500));
        toolbar.add(barright);
        toolbar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        pag.add(prevButton);
        pagination.setText("1");
        JLabel lbl = new JLabel(" / " + totalPages);
        pag.add(pagination);
        pag.add(lbl);
        pag.add(nextButton);
        pag.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        addProductCards(productContainer);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    pagination.setText("" + currentPage);
                    addProductCards(productContainer); // Update the product cards
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    pagination.setText("" + currentPage);
                    addProductCards(productContainer); // Update the product cards
                }
            }
        });
        mainUI.add(productContainer);
        mainUI.add(toolbar, BorderLayout.NORTH);
        mainUI.add(pag, BorderLayout.SOUTH);
        mainUI.setBorder(BorderFactory.createTitledBorder("DANH SÁCH SẢN PHẨM"));
		return mainUI;
	}
	public JPanel sidebarUI() {
		JPanel sidebar = new JPanel(new BorderLayout());
		String[] filter = {"Asus", "Dell", "Mac", "Legend", "LG", "Lenovo"};
		// Create a JPanel to hold the title label and JList
        JPanel panel = new JPanel();
        Box b = Box.createVerticalBox();
        panel.setLayout(new BorderLayout());

        // Create a title label
        JLabel titleLabel = new JLabel("THƯƠNG HIỆU");
        panel.add(titleLabel);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(int i = 0; i < filter.length; i++)
            listModel.addElement(filter[i]);
        
        JList<String> jList = new JList<>(listModel);
        jList.setVisibleRowCount(4);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setCellRenderer(new ClickableListCellRenderer());
        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = jList.locationToIndex(evt.getPoint());
                if (index != -1) {
                    String item = listModel.get(index);
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(jList);
        
		sidebar.setPreferredSize(new Dimension(300, 150));
		 int[] data = {30, 40, 20, 10};  // Dữ liệu phần trăm
	        String[] labels = {"A", "B", "C", "D"};  // Nhãn
	        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};  // Màu sắc
	        String title = "Biểu đồ hình tròn";
		sidebar.add(new PieChart(data, labels, colors, title));
		b.add(new RangeSliderDemo().display(0, 100000000));
        b.add(Box.createVerticalStrut(10));
		b.add(panel);
		b.add(scrollPane);
		b.add(Box.createVerticalStrut(50));
		b.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		sidebar.add(b, BorderLayout.SOUTH);
		sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return sidebar;
	}
	private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(52, 152, 219));
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.WHITE));
        label.setForeground(Color.WHITE);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setOpaque(true);
        return label;
    }
    private MouseAdapter createHoverEffect(JLabel label) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBackground(new Color(41, 128, 185)); // Change background color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setBackground(new Color(52, 152, 219)); // Restore original background color
            }
        };
    }

	public JPanel menuUI() {
		JPanel pMenu = new JPanel(new GridLayout(1, 7));
		btnPage1 = createStyledLabel("<html><b style='color: #ffffff'>BÁN HÀNG</b></html>");
        btnPage2 = createStyledLabel("<html><b style='color: #ffffff'>SẢN PHẨM</b></html>");
        btnPage3 = createStyledLabel("<html><b style='color: #ffffff'>KHÁCH HÀNG</b></html>");
        btnPage4 = createStyledLabel("<html><b style='color: #ffffff'>NHÂN VIÊN</b></html>");
        btnPage5 = createStyledLabel("<html><b style='color: #ffffff'>THỐNG KÊ</b></html>");
        btnPage6 = createStyledLabel("<html><b style='color: #ffffff'>HOÁ ĐƠN</b></html>");
        btnPage7 = createStyledLabel("<html><b style='color: #ffffff'>NHÀ CUNG CẤP</b></html>");
        btnPage1.addMouseListener(createHoverEffect(btnPage1));
        btnPage2.addMouseListener(createHoverEffect(btnPage2));
        btnPage3.addMouseListener(createHoverEffect(btnPage3));
        btnPage4.addMouseListener(createHoverEffect(btnPage4));
        btnPage5.addMouseListener(createHoverEffect(btnPage5));
        btnPage6.addMouseListener(createHoverEffect(btnPage6));
        btnPage7.addMouseListener(createHoverEffect(btnPage7));
		pMenu.setPreferredSize(new Dimension(1000, 50));
		pMenu.add(btnPage1);
		pMenu.add(btnPage2);
		pMenu.add(btnPage3);
		pMenu.add(btnPage4);
		pMenu.add(btnPage5);
		pMenu.add(btnPage6);
		pMenu.add(btnPage7);
		return pMenu;
	}
	public void createBorder(JPanel p, int i) {
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, i));
	}
	public JTextField BTextField() {
		JTextField txt = new JTextField(5);
        txt.setBackground(new Color(0, 0, 0, 0));
		txt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		txt.setHorizontalAlignment(JTextField.CENTER);
		txt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		int m = Integer.parseInt(txt.getText());
            		if(m >= currentPage)
            			nextButton.requestFocus();
            		else
            			prevButton.requestFocus();
            	}catch (Exception e2) {
					nextButton.requestFocus();
				}
            }
        });
		txt.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				txt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String n = txt.getText();
				if(txt.getText().isEmpty())
					txt.setText(""+currentPage);
				else {
					try{
						int m = Integer.parseInt(n);
						if( m > 10)
							n = "10";
						txt.setText(n);
					}catch (Exception e1){
						n = "10";
						txt.setText(n);
					}
				}
			}
           
        });
		return txt;
	}
	public static void main(String[] args) {
		new Inventory().setVisible(true);
	}
}

