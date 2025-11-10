package com.lsk.springFrameWork.factory.support;

import com.lsk.springFrameWork.BeansException;
import com.lsk.springFrameWork.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {

        Object bean = null;
        try {
            bean = createBeanInstance(name, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(name, bean);
        return bean;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {

        try {
            Constructor constructorToUse = null;
            Constructor[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                if (args != null && args.length == constructor.getParameters().length) {
                    constructorToUse = constructor;
                    break;
                }
            }
            return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
