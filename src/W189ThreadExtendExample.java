class TestNewThread extends Thread {
    private int sleepTime;

    public TestNewThread(String name, int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Watek: " + this.getName() + ", wartosc i: " + i);
            try {
                this.sleep(this.sleepTime);
                //System.out.println("Watek: " + this.getName()+" obudził się");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class W189ThreadExtendExample {
    public static void main(String[] args) {
        TestNewThread thread1 = new TestNewThread("PIERWSZY", 1000);
        thread1.start();
        TestNewThread thread2 = new TestNewThread("DRUGI", 500);
        thread2.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("\t\tWatek GLOWNY, wartosc i: " + i);
            try {
                Thread.sleep(200);
                //System.out.println("\t\tWatek GLOWY obudził się");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
