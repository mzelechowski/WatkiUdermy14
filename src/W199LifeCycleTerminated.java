public class W199LifeCycleTerminated {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println("Thread state: "+thread.getState());
    }
}
