package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ProductCardDemo extends JFrame {

    private static final long serialVersionUID = 1L;

	public ProductCardDemo() {
        setTitle("Product Card Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold the product cards and the pie chart
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Create a panel for the product cards
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the pie chart
        JPanel pieChartPanel = new JPanel(new BorderLayout());
        pieChartPanel.setPreferredSize(new Dimension(200, 200));
        contentPanel.add(pieChartPanel, BorderLayout.WEST);

        contentPanel.setBorder(BorderFactory.createTitledBorder(null, "Product List"));

        int[] data = {30, 40, 20, 10};  // Dữ liệu phần trăm
        String[] labels = {"A", "B", "C", "D"};  // Nhãn
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};  // Màu sắc
        String title = "Biểu đồ hình tròn";

        PieChart pieChart = new PieChart(data, labels, colors, title);
        System.out.println(pieChart);
        pieChartPanel.add(pieChart);

        // Add product cards to the panel
        for (int i = 1; i <= 3; i++) {
            JPanel productCard = createProductCard("Product " + i, "$" + (i * 5));
            productPanel.add(productCard);
        }

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createProductCard(String productName, String price) {
        JPanel productCard = new JPanel();
        productCard.setPreferredSize(new Dimension(400, 200));
        productCard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel productNameLabel = new JLabel("Product Name: " + productName);
        JLabel priceLabel = new JLabel("Price: " + price);
        JButton buyButton = new JButton("Buy Now");

        productCard.add(productNameLabel);
        productCard.add(priceLabel);
        productCard.add(buyButton);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ProductCardDemo.this, "You clicked Buy Now for " + productName);
            }
        });

        return productCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductCardDemo productCardDemo = new ProductCardDemo();
                productCardDemo.setVisible(true);
            }
        });
    }

//    class PieChart extends JComponent {
//        private static final long serialVersionUID = 1L;
//		private int total;
//        private int sold;
//
//        public PieChart(int total, int sold) {
//            this.total = total;
//            this.sold = sold;
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            int width = 400;
//            int height = 200;
//
//            // Calculate angles for the pie chart sections
//            double angleTotal = 360.0;
//            double angleSold = (double) sold / total * angleTotal;
//
//            // Draw the pie chart
//            g.setColor(Color.BLUE);
//            g.fillArc(1, 1, width, height, 1, (int) angleSold);
//
//            g.setColor(Color.black);
//            g.fillArc(2, 2, width, height, (int) angleSold, (int) (angleTotal - angleSold));
//        }
//    }
}
