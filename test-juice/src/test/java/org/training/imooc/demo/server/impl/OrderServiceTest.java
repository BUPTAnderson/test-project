package org.training.imooc.demo.server.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import org.junit.Before;
import org.junit.Test;
import org.training.imooc.demo.server.OrderService;
import org.training.imooc.demo.server.PriceService;

import java.util.List;

/**
 * Created by Anderson on 2019/7/10
 */
public class OrderServiceTest {
    @Inject
    private OrderService orderService;
    @Inject
    @Named("supportedCurrencies")
    private Provider<List<String>> supportedCurrenciesProvider;

    @Inject
    private PriceService priceService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule()
//                ,
//                new AbstractModule() {
//                    @Override
//                    protected void configure() {
//                        bind(PriceServiceImp.class) // 连接绑定： 已有的绑定可以继续绑定新的实现
//                                .toInstance(new PriceServiceImp() {
//                                    @Override
//                                    public long getPrice(long orderId) {
//                                        return 567L;
//                                    }
//                                });
//                    }
//                }
        ).injectMembers(this);
    }

    @Test
    public void testSendToPayment() {
//        OrderService orderService = Guice.createInjector(new ServerModule()).getInstance(OrderService.class);
        orderService.sendToPayment(789L);
    }

    @Test
    public void testSupportedCuuencies() {
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}
