package com.lsk.springFrameWork.factory.support;

import com.lsk.springFrameWork.BeansException;
import com.lsk.springFrameWork.factory.config.BeanDefinition;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {

        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
            addSingleton(name, bean);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
    }

}
