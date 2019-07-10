package org.training.csdn.three;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
