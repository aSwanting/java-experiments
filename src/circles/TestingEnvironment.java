package circles;

import javax.swing.*;

public class TestingEnvironment {

    JFrame testFrame;

    public TestingEnvironment(JComponent component) {
        this.testFrame = new JFrame();
        this.testFrame.add(component);
//        this.testFrame.setSize(1000, 500);
        this.testFrame.pack();
        this.testFrame.setLocationRelativeTo(null);
        this.testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.testFrame.setVisible(true);
    }

    public void addPanel(JComponent panel) {
        this.testFrame.add(panel);
    }
}
