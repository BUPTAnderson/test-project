package org.training.csdn.eight;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    void sayHello();
}
