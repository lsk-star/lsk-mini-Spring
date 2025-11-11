package com.lsk.springFrameWork.factory;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;


    Object getBean(String name, Object... args) throws Exception;


}
