package com.lskspringFrameWork.beans.factory.support;



import com.lskspringFrameWork.beans.factory.BeansException;
import com.lskspringFrameWork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 基于jdk 反射的实例化策略
 *
 * @author Li Shuokang
 * @date 2025/11/10
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();

        try {
            if (null != ctor) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
