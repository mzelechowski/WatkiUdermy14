public class W194LifeCycleNew {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Working thread");
            }
        });

        //thread.start();  // wątek istnieje w posatci obiektu ale jeszcze nie zotał uruchomiony
        System.out.println("Stan wątku: " +thread.getState());
    }
}
