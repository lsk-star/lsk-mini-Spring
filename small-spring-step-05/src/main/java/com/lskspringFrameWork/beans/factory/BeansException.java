package com.lskspringFrameWork.beans.factory;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
