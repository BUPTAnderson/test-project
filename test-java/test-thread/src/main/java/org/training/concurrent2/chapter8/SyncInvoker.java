package org.training.concurrent2.chapter8;

public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();

//        Future<String> future = futureService.submit(() -> {
//            try {
//                Thread.sleep(10_000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "FINISH";
//        }, System.out::println);

        futureService.submit(() -> {
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }, System.out::println);

        System.out.println("==============");
        System.out.println("do othre thing.");
        Thread.sleep(5_000);
        System.out.println("==================");

//        System.out.println(future.get());
    }

    private static String get() throws InterruptedException {
        Thread.sleep(100000L);
        return "FINISH";
    }
}
