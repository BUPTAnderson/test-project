package org.training.concurrent2.chapter12;

public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("/Users/anderson/IdeaProjects/test-project/test-java/test-thread/src/main/resources/balking.txt", "======BEGIN======");
        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
