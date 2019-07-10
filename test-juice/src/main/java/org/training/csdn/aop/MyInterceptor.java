package org.training.csdn.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * Created by Anderson on 2019/7/9
 */
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String info = methodInvocation.getMethod().getDeclaringClass() + "." +
                methodInvocation.getMethod().getName() + "()";

        System.out.println(info);

        try {
            Object result = methodInvocation.proceed();
            return result;
        } finally {
            System.out.println(info);
        }
    }
}
