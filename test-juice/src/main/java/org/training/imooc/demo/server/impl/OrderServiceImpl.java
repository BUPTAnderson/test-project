package org.training.imooc.demo.server.impl;

import org.training.imooc.demo.server.OrderService;
import org.training.imooc.demo.server.PaymentService;
import org.training.imooc.demo.server.PriceService;

import javax.inject.Inject;

/**
 * Created by Anderson on 2019/7/10
 */
public class OrderServiceImpl implements OrderService {
    // Dependencies
    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;

    // States
    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    @Override
    public void sendToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price, sessionManager.getSessionId());
        ordersPaid += 1;

        throw new RuntimeException(
                "Price=" + price
                + ". SessionId="
                + sessionManager.getSessionId()
                + ", ordersPaid=" + ordersPaid
        );
    }
}
