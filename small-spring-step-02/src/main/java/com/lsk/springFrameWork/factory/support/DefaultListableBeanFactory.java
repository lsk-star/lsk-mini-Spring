package com.lsk.springFrameWork.factory.support;

import com.lsk.springFrameWork.BeansException;
import com.lsk.springFrameWork.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public  class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {


    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
