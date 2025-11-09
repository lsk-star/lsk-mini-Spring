package com.lsk.springFrameWork.test;

import com.lsk.springFrameWork.BeanDefinition;
import com.lsk.springFrameWork.BeanFactory;
import com.lsk.springFrameWork.test.bean.UserService;
import org.junit.Test;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class ApiTeat {

    @Test
    public void test_BeanFactory(){
        BeanFactory beanFactory=new BeanFactory();
        beanFactory.registerBean("userService",new BeanDefinition(new UserService()));

        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.queryUserInfo();
    }
}
