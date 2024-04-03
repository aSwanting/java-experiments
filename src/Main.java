import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main extends JComponent {
    static int count = 0;
    static int delay;
    static JLabel j1;
    static int avg = 0;

    static Test01 testCircle;


    static void populateApp() {
        SwingUtilities.invokeLater(() -> {

            AppGUI appGUI = new AppGUI();
            appGUI.initGUI();

            double w = appGUI.p1.getWidth();
            double h = appGUI.p1.getHeight();

            testCircle = new Test01(w / 2, h / 3, 50, 0, 0);
            appGUI.p1.add(testCircle);

            LineBorder lineBorder = new LineBorder(Color.white);
            EmptyBorder emptyBorder = new EmptyBorder(20, 20, 20, 20);
            CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);

            j1 = new JLabel();
            j1.setForeground(Color.white);
            j1.setSize(300, 30);
            j1.setHorizontalAlignment(SwingConstants.CENTER);
            j1.setBorder(compoundBorder);
            appGUI.p2.add(j1);
        });
    }


    static void startLoop() {

        delay = 16;

        Thread gameLoop = new Thread(() -> {

            while (count < 1000) {
                if (count % 60 == 0) {
                    avg = 1000 / delay;
                }

                SwingUtilities.invokeLater(() -> {
                    j1.setText("<html><div style='text-align: center'>Total Frames: " + count + " <br> FPS: " + avg + "</div></html>");
                    testCircle.move();
                    testCircle.accelerate(delay);
                    testCircle.repaint();
                });

                count++;

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        gameLoop.start();
    }

    public static void main(String[] args) {
        populateApp();
        startLoop();
    }
}
