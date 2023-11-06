package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductCardScrollDemo extends JFrame {

    public ProductCardScrollDemo() {
        setTitle("Product Card Scroll Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold the product cards with a vertical scroll bar
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // Add product cards to the panel
        for (int i = 1; i <= 20; i++) {
            JPanel productCard = createProductCard("Product " + i, "$" + (i * 5));
            productPanel.add(productCard);
        }

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createProductCard(String productName, String price) {
    	JPanel productCard = new JPanel();
        productCard.setPreferredSize(new Dimension(300, 200));
        productCard.setLayout(new BorderLayout());

        // Load the image
        ImageIcon imageIcon = new ImageIcon("/img/products/UI.png");
        JLabel imageLabel = new JLabel(imageIcon);

        // Create a label for the product name
        JLabel productNameLabel = new JLabel(productName);
        productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productNameLabel.setForeground(Color.WHITE);

        // Create a layered pane to stack image and label
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 200));

        // Set the image label to the background layer
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        layeredPane.add(productNameLabel, JLayeredPane.POPUP_LAYER);

        productCard.add(layeredPane, BorderLayout.CENTER);
        layeredPane.setBorder(BorderFactory.createTitledBorder("asd"));

        productCard.setBorder(BorderFactory.createTitledBorder("123"));

        // ... Rest of the code
        return productCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductCardScrollDemo productCardScrollDemo = new ProductCardScrollDemo();
                productCardScrollDemo.setVisible(true);
            }
        });
    }
}
