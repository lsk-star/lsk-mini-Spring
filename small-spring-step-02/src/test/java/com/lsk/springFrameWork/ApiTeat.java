package com.lsk.springFrameWork;


import com.lsk.springFrameWork.bean.UserService;
import com.lsk.springFrameWork.factory.config.BeanDefinition;
import com.lsk.springFrameWork.factory.support.AbstractBeanFactory;
import com.lsk.springFrameWork.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class ApiTeat {

    @Test
    public void test_BeanFactory() throws Exception {

        DefaultListableBeanFactory defaultListableBeanFactory =new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));

        UserService bean = (UserService) defaultListableBeanFactory.getBean("userService");
        bean.queryUserInfo();
//
//
//        UserService bean2 = (UserService) defaultListableBeanFactory.getBean("userService");
//        bean2.queryUserInfo();
//        System.out.println(bean == bean2);

        AbstractBeanFactory abstractBeanFactory = new DefaultListableBeanFactory();

        UserService bean3 = (UserService) abstractBeanFactory.getBean("userService");
        bean3.queryUserInfo();






    }
}
