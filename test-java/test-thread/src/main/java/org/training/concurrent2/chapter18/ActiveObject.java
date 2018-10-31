package org.training.concurrent2.chapter18;

public interface ActiveObject {
    Result makeString(int count, char fillChar);
    void displayString(String text);
}
