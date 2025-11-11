package com.lskspringFrameWork.core.io;

import cn.hutool.core.lang.Assert;
import com.lskspringFrameWork.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径下的资源
 *
 * @author Li Shuokang
 * @date 2025/11/11
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(this.path);
        if (is == null) {
            throw new IOException("can not find resource:" + this.path);
        }
        return is;
    }
}
