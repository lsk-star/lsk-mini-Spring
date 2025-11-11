package com.lsk.springFrameWork.factory.config;

/**
 *  bean定义，存储bean的配置信息
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */

@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

   private Class beanClass;


    public BeanDefinition(Class beanClass) {

        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
