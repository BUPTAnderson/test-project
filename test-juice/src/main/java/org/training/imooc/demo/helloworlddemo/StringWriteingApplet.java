package org.training.imooc.demo.helloworlddemo;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.training.imooc.demo.MyApplet;

/**
 * Created by Anderson on 2019/7/10
 */
public class StringWriteingApplet implements MyApplet {
    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWriteingApplet(MyDestination destination, @Output Provider<String> stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }
    @Override
    public void run() {
        writeString();
    }
}
