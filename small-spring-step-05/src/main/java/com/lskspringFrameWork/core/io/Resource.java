package com.lskspringFrameWork.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *  资源接口
 *
 * @author Li Shuokang
 * @date 2025/11/11
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
