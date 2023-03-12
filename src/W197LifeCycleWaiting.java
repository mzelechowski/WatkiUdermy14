class TestThread extends Thread {
    Thread mainThread;

    public TestThread(String name, Thread mainThread) {
        super(name);
        this.mainThread=mainThread;
    }

    public void run() {
        System.out.println(getName() + " started.");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println("Main thread state: "+mainThread.getState());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " finished");
    }
}

public class W197LifeCycleWaiting {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread(); //dostęp do głównego wątku main
        TestThread thread1 = new TestThread("Watek-1", mainThread);
        thread1.start();
        thread1.join(); //watek glowny main czeka az watek watek1 skoczny dzialanie
        System.out.println("Main thread");
    }
}
