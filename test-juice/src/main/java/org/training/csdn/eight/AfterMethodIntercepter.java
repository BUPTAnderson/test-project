package org.training.csdn.eight;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Anderson on 2019/7/9
 */
//这个切面依赖前置服务
public class AfterMethodIntercepter implements MethodInterceptor {
    @Inject
    private BeforeService beforeService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        beforeService.before(invocation);
        Object obj = null;
        try {
            obj = invocation.proceed();
        } finally {
            System.out.println("after--->" + invocation.getClass().getName());
        }
        return obj;
    }
}
