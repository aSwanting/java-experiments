package circles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TestPanel extends JPanel {

    int w, h;
    Circle c1, c2;

    public TestPanel(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        c1 = new Circle(100, 0, 0);
        c2 = new Circle(100, w, h);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawCircle(g2d, c1, new Color(0, 0, 0, 128));
        drawCircle(g2d, c2, new Color(0, 0, 0, 128));

    }

    private void drawCircle(Graphics2D g2d, Circle c, Color color) {
        Shape circle = new Ellipse2D.Double(c.x, c.y, c.d, c.d);
        g2d.setColor(color);
        g2d.fill(circle);
    }

    public void run() throws InterruptedException {
        while (true) {
            c1.move1();
            c2.move2();
            repaint();
            Thread.sleep(6);
        }
    }
}

