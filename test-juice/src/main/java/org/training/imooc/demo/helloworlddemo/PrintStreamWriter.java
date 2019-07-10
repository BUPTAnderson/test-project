package org.training.imooc.demo.helloworlddemo;

import com.google.inject.Inject;

import java.io.PrintStream;

/**
 * Created by Anderson on 2019/7/10
 */
public class PrintStreamWriter implements MyDestination {
    private PrintStream destination;

    @Inject
    public PrintStreamWriter(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String s) {
        destination.println(s);
    }
}
