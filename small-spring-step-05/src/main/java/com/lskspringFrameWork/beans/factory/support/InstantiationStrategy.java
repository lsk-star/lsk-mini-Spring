package com.lskspringFrameWork.beans.factory.support;



import com.lskspringFrameWork.beans.factory.BeansException;
import com.lskspringFrameWork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 *
 * @author Li Shuokang
 * @date 2025/11/10
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
