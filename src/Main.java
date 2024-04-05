import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Scanner;

public class Main extends JComponent {
    static int count = 0;
    static int delay;
    static JLabel j1;
    static int avg = 0;
    static Circle testCircle;
    static AppGUI appGUI;

    static void populateApp(Boolean userInput) {

        double x;
        double y;
        double r;
        double vx;
        double vy;

        if (userInput) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter circle parameters:");
            System.out.print("x position: ");
            x = Double.parseDouble(scan.nextLine());
            System.out.print("y position: ");
            y = Double.parseDouble(scan.nextLine());
            System.out.print("radius: ");
            r = Double.parseDouble(scan.nextLine());
            System.out.print("x velocity: ");
            vx = Double.parseDouble(scan.nextLine());
            System.out.print("y velocity: ");
            vy = Double.parseDouble(scan.nextLine());
            scan.close();

        } else {
            x = 100;
            y = 300;
            r = 50;
            vx = 26;
            vy = -32;
        }

        SwingUtilities.invokeLater(() -> {
            appGUI = new AppGUI();
            appGUI.initGUI();
            testCircle = new Circle(x, y, r, vx, vy);
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
                    System.out.printf("%.3f - %.3f\n", testCircle.vx, testCircle.vy);
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
        populateApp(false);

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        startLoop();
    }
}
