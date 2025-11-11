package com.lskspringFrameWork.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载器
 *
 * @author Li Shuokang
 * @date 2025/11/11
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
                return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {

            try {

                URL url = new URL(location);
                return new UrlResource(url);

            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
