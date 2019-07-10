package org.training.csdn.six;

import com.google.inject.Provider;

/**
 * Created by Anderson on 2019/7/9
 */
public class OneServiceProvider implements Provider<Service> {
    @Override
    public Service get() {
        return new OneService();
    }
}
