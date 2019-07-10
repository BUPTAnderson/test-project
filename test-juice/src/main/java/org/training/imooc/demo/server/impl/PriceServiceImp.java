package org.training.imooc.demo.server.impl;

import com.google.inject.Inject;
import org.training.imooc.demo.server.PriceService;

import java.util.Set;

/**
 * Created by Anderson on 2019/7/10
 */
public class PriceServiceImp implements PriceService {
    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImp(Set<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    @Override
    public long getPrice(long orderId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getSupportedCurrencies() {
//        return Arrays.asList("CNY", "USD", "EUR");
        return supportedCurrencies;
    }
}
