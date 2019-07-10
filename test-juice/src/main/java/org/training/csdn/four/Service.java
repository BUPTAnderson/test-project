package org.training.csdn.four;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
