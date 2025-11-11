package com.lskspringFrameWork.beans.factory.support;

import com.lskspringFrameWork.beans.factory.BeansException;
import com.lskspringFrameWork.core.io.Resource;
import com.lskspringFrameWork.core.io.ResourceLoader;

/**
 *  bean定义读取器
 *
 * @author Li Shuokang
 * @date 2025/11/11
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
