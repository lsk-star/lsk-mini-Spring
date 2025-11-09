package com.lsk.springFrameWork;

/**
 * bean的定义
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class BeanDefinition {



    private Object bean;


    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }


}
