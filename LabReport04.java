package javaapplication41;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class LabReport04 extends JFrame {
    private DrawingPanel drawingPanel;
    public LabReport04() {
        setTitle("Lab Report 04 - GUI Circle Drawer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton btnDraw = new JButton("Draw Circle");
        JButton btnClear = new JButton("Clear");
        buttonPanel.add(btnDraw);
        buttonPanel.add(btnClear);
        add(buttonPanel, BorderLayout.SOUTH);
        btnDraw.addActionListener(e -> drawingPanel.addCircle());
        btnClear.addActionListener(e -> drawingPanel.clearPanel());
    }
    class DrawingPanel extends JPanel {
        private final ArrayList<Point> circles = new ArrayList<>();
        private final Random random = new Random();
        private static final int RADIUS = 40;
        public void addCircle() {
            int x = random.nextInt(Math.max(1, getWidth() - RADIUS));
            int y = random.nextInt(Math.max(1, getHeight() - RADIUS));
            circles.add(new Point(x, y));
            repaint();
        }
        public void clearPanel() {
            circles.clear();
            repaint();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for (Point p : circles) {
                g.fillOval(p.x, p.y, RADIUS, RADIUS);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LabReport04().setVisible(true);
        });
    }
}