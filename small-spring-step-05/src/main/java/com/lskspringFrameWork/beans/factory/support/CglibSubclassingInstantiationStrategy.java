package com.lskspringFrameWork.beans.factory.support;


import com.lskspringFrameWork.beans.factory.BeansException;
import com.lskspringFrameWork.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * 基于 cglib 的实例化策略----------->   注意： cglib 对java9以上有版本冲突问题，如报错，请切换 jdk版本
 *
 * @author Li Shuokang
 * @date 2025/11/10
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();

        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new NoOp() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            });

            if (ctor != null) {
                return enhancer.create(ctor.getParameterTypes(), args);
            }
            return enhancer.create();

        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
