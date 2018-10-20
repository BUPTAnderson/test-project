package org.training.concurrent.chapter12;

public class ThradGroupCreate2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
//                while (true) {
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
        };

//        tg1.setDaemon(true);
        t1.start();
        Thread.sleep(2_000L);
        System.out.println(tg1.isDestroyed());
        tg1.destroy();
        System.out.println(tg1.isDestroyed());
    }
}
