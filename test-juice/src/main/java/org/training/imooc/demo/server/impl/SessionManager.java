package org.training.imooc.demo.server.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Created by Anderson on 2019/7/10
 */
public class SessionManager {
    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(
            @SessionId Provider<Long> sessionIdProvider) {
        this.sessionIdProvider = sessionIdProvider;
    }

    public Long getSessionId() {
        return sessionIdProvider.get();
    }
}
