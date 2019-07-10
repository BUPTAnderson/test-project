package org.training.csdn.one;

import com.google.inject.ImplementedBy;

/**
 * Created by Anderson on 2019/7/9
 */
@ImplementedBy(HelloGuiceImpl.class)
public interface HelloGuice {
    public void sayHello();
}
