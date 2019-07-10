package org.training.csdn.eight;

import com.google.inject.ImplementedBy;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Anderson on 2019/7/9
 */
@ImplementedBy(BeforeServiceImpl.class)
public interface BeforeService {
    void before(MethodInvocation invocation);
}
