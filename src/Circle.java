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

    private static double accelFormula(double delay, double multiplier) {
        return multiplier * (delay / 1000);
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

        double h = bounds.getHeight() - r;
        double w = bounds.getWidth() - r;

        if (y < 0) {
            y = 0;
            vy *= -0.98;
        }

        if (y > h) {
            y = h;
            vy *= -0.75;
        }

        if (x < 0) {
            x = 0;
            vx *= -0.92;
        }

        if (x > w) {
            x = w;
            vx *= -0.92;
        }

        x += vx;
        y += vy;
    }

    public void accelerate(double delay) {

        double xMultiplier = 0.8;
        double yMultiplier = 48;

        double xFormula = vx < 0 ? accelFormula(delay, xMultiplier)
                : accelFormula(delay, xMultiplier) * -1;
        double yFormula = accelFormula(delay, yMultiplier);

        vx += xFormula;
        vy += yFormula;

    }
}
