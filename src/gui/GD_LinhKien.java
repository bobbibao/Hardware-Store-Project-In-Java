package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class GD_LinhKien extends GD_Layout{
	private static final long serialVersionUID = 1L;
    private int currentPage = 1;
    private int itemsPerPage = 15;
    private int totalProducts = 100;
    private int totalPages= (int) Math.ceil((double) totalProducts / itemsPerPage);
	private JCheckBox isActive;
	private JButton prevButton;
	private JButton nextButton;
	public GD_LinhKien() {
		super("QUẢN LÝ SẢN PHẨM");
	}
	@Override
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
        btnAdd.setBorder(BorderFactory.createEmptyBorder(0,0, 10,0));
        productCard.add(p1);
        productCard.add(p2);
        productCard.add(p3);
        p1.add(imageLabel);
        p2.add(lblProductName);
        p3.add(btnAdd);
        p1.setPreferredSize(new Dimension(100, 118));
        p2.setPreferredSize(new Dimension(100, 13));
        p3.setPreferredSize(new Dimension(100, 10));
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
		new GD_LinhKien().setVisible(true);
	}
}

