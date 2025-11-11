package com.lsk.springFrameWork.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.lsk.springFrameWork.BeansException;
import com.lsk.springFrameWork.PropertyValue;
import com.lsk.springFrameWork.PropertyValues;
import com.lsk.springFrameWork.factory.config.BeanDefinition;
import com.lsk.springFrameWork.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.List;

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

            //实例化bean
            bean = createBeanInstance(name, beanDefinition, args);

            //为bean填充属性
            applyPropertyValues(name, beanDefinition, bean);

        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(name, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) {
        try {
            List<PropertyValue> propertyValueList = beanDefinition.getPropertyValues().getPropertyValueList();
            for (PropertyValue propertyValue : propertyValueList) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

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
