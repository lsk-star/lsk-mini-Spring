package com.lsk.springFrameWork.factory.support;

import com.lsk.springFrameWork.factory.BeanFactory;
import com.lsk.springFrameWork.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {

        Object singletonBean = getSingleton(name);
        if (singletonBean != null) {
            return singletonBean;
        }

       BeanDefinition beanDefinition= getBeanDefinition(name);
       return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String name);
}
