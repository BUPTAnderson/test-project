package org.training.imooc.demo.server;

import java.util.Set;

public interface PriceService {
    long getPrice(long orderId);

    Set<String> getSupportedCurrencies();
}
