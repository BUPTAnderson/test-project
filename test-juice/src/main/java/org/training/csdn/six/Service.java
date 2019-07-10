package org.training.csdn.six;

import com.google.inject.ProvidedBy;

@ProvidedBy(OneServiceProvider.class)
public interface Service {
    void execute();
}
