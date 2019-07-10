package org.training.imooc.demo.server.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by Anderson on 2019/7/10
 */
public class SessionManagerTest {
    @Inject
    SessionManager sessionManager;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void testGetSessionId() throws InterruptedException {
        Long sessionId = sessionManager.getSessionId();
        Thread.sleep(1000L);
        Long sessionId2 = sessionManager.getSessionId();
        assertNotEquals(sessionId2.longValue(), sessionId.longValue());
    }
}
