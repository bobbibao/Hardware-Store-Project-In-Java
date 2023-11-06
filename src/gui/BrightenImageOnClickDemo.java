package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.RescaleOp;

public class BrightenImageOnClickDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Brighten Image on Click Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        JPanel panel = new JPanel();

        // Load the image
        ImageIcon imageIcon = createImageIcon("img/icons/loupe.png");
        JLabel imageLabel = new BrightenImageLabel(imageIcon);

        // Add a MouseListener to brighten the image when clicked
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (imageLabel instanceof BrightenImageLabel) {
                    BrightenImageLabel brightenImageLabel = (BrightenImageLabel) imageLabel;
                    brightenImageLabel.setBright(true);
                    brightenImageLabel.repaint();
                }
            }
        });

        panel.add(imageLabel);
        frame.add(panel);
        frame.setVisible(true);
    }

    private static ImageIcon createImageIcon(String path) {
        ImageIcon icon = null;
        try {
            BufferedImage image = ImageIO.read(new File(path));
            icon = new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
}

class BrightenImageLabel extends JLabel {
    private boolean bright;

    public BrightenImageLabel(ImageIcon icon) {
        super(icon);
        this.bright = false;
    }

    public void setBright(boolean bright) {
        this.bright = bright;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (bright) {
            BufferedImage image = new BufferedImage(getIcon().getIconWidth(), getIcon().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, null);

            float scaleFactor = 1.2f; // Brighten factor
            RescaleOp op = new RescaleOp(scaleFactor, 0, null);
            image = op.filter(image, null);

            g.drawImage(image, 0, 0, this);
        } else {
            super.paintComponent(g);
        }
    }
}
