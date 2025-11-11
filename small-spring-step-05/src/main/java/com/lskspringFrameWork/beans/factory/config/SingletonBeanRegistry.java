package com.lskspringFrameWork.beans.factory.config;

/**
 * 单例Bean注册器
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
