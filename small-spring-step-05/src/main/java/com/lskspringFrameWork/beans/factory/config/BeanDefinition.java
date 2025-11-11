package com.lskspringFrameWork.beans.factory.config;


import com.lskspringFrameWork.beans.factory.PropertyValues;

/**
 * bean定义，存储bean的配置信息
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */

@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
