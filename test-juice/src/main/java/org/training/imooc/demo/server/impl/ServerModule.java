package org.training.imooc.demo.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import org.training.imooc.demo.server.OrderService;
import org.training.imooc.demo.server.PaymentService;
import org.training.imooc.demo.server.PriceService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Anderson on 2019/7/10
 */
public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ChinaModule());
        install(new GlobalModule());
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImp.class);
//        bind(PriceService.class).toInstance(new PriceServiceImp());
//        bind(Long.class).annotatedWith(SessionId.class).toInstance(System.currentTimeMillis()); // 这样初始化的时候就确定了，是一个固定的值了，下面的@Provides方法每次调用的时候会创建一个新的
//        bind(Long.class).annotatedWith(Names.named("appId")).toInstance(456L);
        // 范型绑定
        bind(new TypeLiteral<List<String>>() {
        })
                .annotatedWith(Names.named("supportedCurrencies"))
                .toInstance(Arrays.asList("CNY", "USD", "EUR"));
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

//    @Provides
//    @Named("supportedCurrencies")
//    List<String> getSupportedCurrencies(PriceService priceService) {
//        return priceService.getSupportedCurrencies();
//    }
}
