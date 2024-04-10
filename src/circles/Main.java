package circles;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TestPanel testPanel = new TestPanel(500, 500);
        TestingEnvironment testingEnvironment = new TestingEnvironment(testPanel);

        testPanel.run();

    }
}
