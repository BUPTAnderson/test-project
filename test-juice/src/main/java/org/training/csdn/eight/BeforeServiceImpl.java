package org.training.csdn.eight;

import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Anderson on 2019/7/9
 */
public class BeforeServiceImpl implements BeforeService {
    @Override
    public void before(MethodInvocation invocation) {
        System.out.println("Before--->" + invocation.getClass().getName());
    }
}
