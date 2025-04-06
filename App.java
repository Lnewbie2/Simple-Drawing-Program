import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class App extends JFrame {
    private DrawPanel drawPanel;

    public App() {
        setTitle("Simple Drawing Program");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
    }

    private static class DrawPanel extends JPanel {
        private List<Point> points = new ArrayList<>();

        public DrawPanel() {
            setBackground(Color.WHITE);
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            for (Point p : points) {
                g.fillOval(p.x, p.y, 5, 5);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App frame = new App();
            frame.setVisible(true);
        });
    }
}