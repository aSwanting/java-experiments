import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Test01 extends JComponent {
    public double x, y, r, d, vx, vy;

    public Test01(double x, double y, double r, double vx, double vy) {
        this.r = r;
        this.d = r / 2;
        this.x = x - d;
        this.y = y - d;
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape shape = new Ellipse2D.Double(x, y, r, r);
        g2d.fill(shape);
    }

    public void move() {

        if (y > getHeight() - r) {
            y = getHeight() - r;
            vy *= -0.6;
//            vy *= vy < 0.02 && vy > 0 ? -0.5 : 0;
        }

        x += vx;
        y += vy;
    }

    public void accelerate(double delay) {
//        vx += 10 * (delay / 1000);
        vy += 50 * (delay / 1000);
    }
}
