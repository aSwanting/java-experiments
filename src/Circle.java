import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JComponent {
    public double x, y, r, d, vx, vy;

    public Circle(double x, double y, double r, double vx, double vy) {
        this.r = r;
        this.d = r / 2;
        this.x = x - d;
        this.y = y - d;
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", d=" + d +
                ", vx=" + vx +
                ", vy=" + vy +
                '}';
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape shape = new Ellipse2D.Double(x, y, r, r);
        g2d.fill(shape);
    }

    public void move(JComponent bounds) {

        int h = bounds.getHeight();
        int w = bounds.getWidth();

        if (y < 0) {
            y = 0;
            vy *= -0.9;
        }

        if (y > h - r) {
            y = h - r;
            vy *= -0.6;
        }

        if (x < 0) {
            x = 0;
            vx *= -0.8;
        }

        if (x > w - r) {
            x = w - r;
            vx *= -0.8;
        }

        x += vx;
        y += vy;
    }

    public void accelerate(double delay) {
//        vx += 10 * (delay / 1000);
        vy += 30 * (delay / 1000);
    }
}
