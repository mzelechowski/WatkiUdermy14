public class W200RaceConditionExample {
    public int counter = 0;
    // synchronized - synchronizacja metody dla watkow
    // można synchronizoać blok kodu  synchronized(this){this.counter++;}
    public synchronized void increment(){
        this.counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        W200RaceConditionExample race = new W200RaceConditionExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200000 ; i++) {
                    race.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200000 ; i++) {
                    race.increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter: "+race.counter);
    }
}
