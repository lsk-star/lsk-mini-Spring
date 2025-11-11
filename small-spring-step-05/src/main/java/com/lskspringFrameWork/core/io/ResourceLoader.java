package com.lskspringFrameWork.core.io;

/**
 *  资源加载器
 *
 * @author Li Shuokang
 * @date 2025/11/11
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
