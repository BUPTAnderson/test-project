package org.training.csdn.two;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
