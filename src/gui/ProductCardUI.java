package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductCardUI extends JFrame {

    private JPanel productPanel;
    private int currentPage = 1;
    private int itemsPerPage = 4;

    public ProductCardUI() {
        setTitle("Product Card UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the product cards with a GridLayout
        productPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create product cards and add them to the panel
        addProductCards();

        // Add the product card panel to the main frame
        add(productPanel);

        // Pagination controls
        JPanel paginationPanel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JLabel pageLabel = new JLabel("Page " + currentPage);

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    pageLabel.setText("Page " + currentPage);
                    addProductCards(); // Update the product cards
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalProducts = 10; // Replace with your total number of products
                int totalPages = (int) Math.ceil((double) totalProducts / itemsPerPage);
                if (currentPage < totalPages) {
                    currentPage++;
                    pageLabel.setText("Page " + currentPage);
                    addProductCards(); // Update the product cards
                }
            }
        });

        paginationPanel.add(prevButton);
        paginationPanel.add(pageLabel);
        paginationPanel.add(nextButton);

        add(paginationPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void addProductCards() {
        int start = (currentPage - 1) * itemsPerPage + 1;
        int end = start + itemsPerPage - 1;

        productPanel.removeAll();

        for (int i = start; i <= end; i++) {
            if (i <= 10) { // Replace 10 with the total number of products
                JPanel productCard = createProductCard("Product " + i, "$" + (i * 5));
                productPanel.add(productCard);
            }
        }

        productPanel.revalidate();
        productPanel.repaint();
    }

    private JPanel createProductCard(String productName, String price) {
        JPanel productCard = new JPanel();
        productCard.setPreferredSize(new Dimension(150, 100));
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
                JOptionPane.showMessageDialog(ProductCardUI.this, "You clicked Buy Now for " + productName);
            }
        });

        return productCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductCardUI productCardUI = new ProductCardUI();
                productCardUI.setVisible(true);
            }
        });
    }
}
