package org.training.exceptions;

/**
 * Created by anderson on 16-8-28.
 */

class MyResource implements AutoCloseable {
    public String name = "resource...";
    @Override
    public void close() throws Exception {
        System.out.println("close...");
    }
}

public class TestTryWithResource {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            System.out.println(resource.name);
        } catch (Exception e) {
        }
    }
}
