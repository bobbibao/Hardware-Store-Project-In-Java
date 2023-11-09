package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JLabelDialogDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel Dialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Click me for details!");
        mainPanel.add(label, BorderLayout.WEST);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showDetailsDialog(frame); // Hiển thị cửa sổ dialog khi nhấp chuột
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static void showDetailsDialog(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Details", true);
        dialog.setSize(200, 100);

        JTextArea detailTextArea = new JTextArea("This is the detailed information you requested.");
        detailTextArea.setEditable(false);
        dialog.add(new JScrollPane(detailTextArea));

        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }
}
