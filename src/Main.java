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
    static Circle testCircle;
    static AppGUI appGUI;

    static void populateApp() {
        SwingUtilities.invokeLater(() -> {

            appGUI = new AppGUI();
            appGUI.initGUI();

            testCircle = new Circle(100, 800, 50, 10, -16);
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

        delay = 10;

        Thread gameLoop = new Thread(() -> {

            while (true) {
                if (count % 60 == 0) {
                    avg = 1000 / delay;
                }

                SwingUtilities.invokeLater(() -> {
                    j1.setText("<html><div style='text-align: center'>Total Frames: " + count + " <br> FPS: " + avg + "</div></html>");
                    testCircle.move(appGUI.p1);
                    testCircle.repaint();
                    testCircle.accelerate(delay);
                    System.out.println(testCircle.y);
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
