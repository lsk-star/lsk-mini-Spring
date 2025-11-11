package com.lskspringFrameWork.beans.factory.support;


import com.lskspringFrameWork.beans.factory.config.BeanDefinition;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public interface BeanDefinitionRegistry {

    // 注册bean定义
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
