package org.training.csdn.five;

import com.google.inject.ImplementedBy;
import org.training.csdn.four.ServiceImpl;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
