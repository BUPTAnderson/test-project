package org.training.csdn.two;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloGuiceImpl.class)
public interface HelloGuice {
    void sayHello();
}
