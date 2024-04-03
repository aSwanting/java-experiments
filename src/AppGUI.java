import javax.swing.*;
import java.awt.*;


public class AppGUI extends JComponent {
    public JFrame f;
    public JPanel p1, p2;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(300, 300, 300, 300);
    }

    public void initGUI() {
        f = new JFrame("Java Experiments");
        f.setSize(800, 800);
        f.setLayout(new BorderLayout());

        p1 = new JPanel(new GridLayout());
        p1.setPreferredSize(new Dimension(1000, 900));
        p1.setBackground(Color.gray);
        f.add(p1, BorderLayout.CENTER);

        p2 = new JPanel(new GridLayout());
        p2.setPreferredSize(new Dimension(1000, 100));
        p2.setBackground(Color.darkGray);
        f.add(p2, BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
