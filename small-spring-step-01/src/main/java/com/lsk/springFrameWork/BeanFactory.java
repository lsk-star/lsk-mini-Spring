package com.lsk.springFrameWork;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  bean工厂
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    public void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
