class RunnableClass implements Runnable {
    private int sleepTime;
    private String name;

    public String getName() {
        return name;
    }

    public RunnableClass(String name, int sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Watek: " + this.name
                    + ", wartosc: " + i);
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableClass2 extends RunnableClass implements Runnable{
    private Thread thread;

    public RunnableClass2(String name, int sleepTime) {
        super(name, sleepTime);
    }

    public void start(){
        if (thread==null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}

public class W190RunnableExample {
    public static void main(String[] args) {
        RunnableClass run1 = new RunnableClass("WATEK1", 1000);
        Thread thread1 = new Thread(run1, run1.getName());
        thread1.start();
        RunnableClass run2 = new RunnableClass("WATEK2222", 500);
        Thread thread2 = new Thread(run2, run2.getName());
        thread2.start();
        RunnableClass2 run3 = new RunnableClass2("Watek3333333",400);
        run3.start();
        for (int i = 0; i < 15; i++) {
            System.out.println("\t\tWatek: GLOWNY, wartosc i: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
