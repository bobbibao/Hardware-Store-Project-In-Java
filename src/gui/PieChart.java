package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class PieChart extends JComponent {
    private final int[] data;  // Dữ liệu phần trăm cho biểu đồ
    private final String[] labels;  // Nhãn cho từng phần trăm
    private final Color[] colors;  // Màu sắc cho từng phần trăm
    private final String title; // Tiêu đề cho biểu đồ

    public PieChart(int[] data, String[] labels, Color[] colors, String title) {
        this.data = data;
        this.labels = labels;
        this.colors = colors;
        this.title = title;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int minSize = Math.min(width, height);

        double total = 0;
        for (int value : data) {
            total += value;
        }

        double startAngle = 0;
        int x = (width - minSize) / 2;
        int y = (height - minSize) / 2;
        int diameter = minSize;

        g2.setFont(new Font("SansSerif", Font.BOLD, 18));
        g2.setColor(Color.BLACK);
        g2.drawString(title, (width - g2.getFontMetrics().stringWidth(title)) / 2, 20);

        for (int i = 0; i < data.length; i++) {
            double angle = (data[i] / total) * 360;
            g2.setColor(colors[i]);
            g2.fill(new Arc2D.Double(x, y, diameter, diameter, startAngle, angle, Arc2D.PIE));

            // Vẽ viền cho biểu đồ
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.draw(new Arc2D.Double(x, y, diameter, diameter, startAngle, angle, Arc2D.PIE));

            // Tính toán vị trí và vẽ phần trăm
            double labelAngle = Math.toRadians(startAngle + angle / 2);
            int labelX = (int) (x + diameter / 2 + diameter / 4 * Math.cos(labelAngle));
            int labelY = (int) (y + diameter / 2 + diameter / 4 * Math.sin(labelAngle));
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
            String percentage = String.format("%.1f%%", (data[i] / total) * 100);
            g2.drawString(percentage, labelX, labelY);

            startAngle += angle;
        }

        int legendX = x;
        int legendY = y + diameter;
        int legendWidth = 50;
        int legendHeight = 10;

        for (int i = 0; i < labels.length; i++) {
            g2.setColor(colors[i]);
            g2.fillRect(legendX, legendY, legendWidth, legendHeight);
            g2.setColor(Color.BLACK);
            g2.drawString(labels[i], legendX + legendWidth + 10, legendY + legendHeight);
            legendY += legendHeight + 5;
        }
    }

    public static void main(String[] args) {
        int[] data = {30, 40, 20, 10};  // Dữ liệu phần trăm
        String[] labels = {"A", "B", "C", "D"};  // Nhãn
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};  // Màu sắc
        String title = "Biểu đồ hình tròn";

        JFrame frame = new JFrame("Biểu đồ hình tròn");
        PieChart pieChart = new PieChart(data, labels, colors, title);
        frame.add(pieChart);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
