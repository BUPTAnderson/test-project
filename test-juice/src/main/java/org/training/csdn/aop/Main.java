package org.training.csdn.aop;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 用MethodInterceptor实现AOP
 * 链接：https://dnizna.iteye.com/blog/1157663
 * Created by Anderson on 2019/7/9
 */
public class Main {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("spring.xml");
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        Interface bean = (Interface) beanFactory.getBean("bean");
        bean.hello();

        Interface testBean = (Interface) beanFactory.getBean("testBean");
        testBean.hello();
    }
}
