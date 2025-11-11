package com.lskspringFrameWork.beans.factory.support;


import com.lskspringFrameWork.beans.factory.BeanFactory;
import com.lskspringFrameWork.beans.factory.config.BeanDefinition;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> clazz) throws Exception {
        return (T)getBean(name);
    }

    private <T> T doGetBean(String name, Object[] args) throws Exception {

        Object singletonBean = getSingleton(name);
        if (singletonBean != null) {
            return (T) singletonBean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String name);
}
