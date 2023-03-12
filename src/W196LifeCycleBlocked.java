class SomeThread implements Runnable {

    public static synchronized void test() {
        while (true) {

        }
    }

    @Override
    public void run() {
        test();
    }
}

public class W196LifeCycleBlocked {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SomeThread());
        Thread thread2 = new Thread(new SomeThread());

        thread1.start();
        thread2.start();
        Thread.sleep(100); // aby zobaczyć state drugiego watku odczekujemy chwilę
        System.out.println("Stan watku1: "+thread1.getState()); //RUNNABLE
        System.out.println("Stan watku1: "+thread2.getState()); //BLOCKED
    }
}
