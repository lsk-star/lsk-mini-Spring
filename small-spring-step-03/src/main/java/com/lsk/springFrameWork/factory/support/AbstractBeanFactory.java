package com.lsk.springFrameWork.factory.support;

import com.lsk.springFrameWork.factory.BeanFactory;
import com.lsk.springFrameWork.factory.config.BeanDefinition;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return doGetBean(name, args);
    }

    private Object doGetBean(String name, Object[] args) throws Exception {

        Object singletonBean = getSingleton(name);
        if (singletonBean != null) {
            return singletonBean;
        }

        BeanDefinition beanDefinition= getBeanDefinition(name);
        return createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String name);
}
