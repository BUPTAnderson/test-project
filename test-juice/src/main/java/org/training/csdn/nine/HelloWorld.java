package org.training.csdn.nine;

import com.google.inject.ImplementedBy;

import java.io.IOException;

@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld {
    void execute() throws IOException;
}
