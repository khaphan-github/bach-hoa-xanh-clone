package com.bhx.product.exception;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
public class ProductNotFoundException extends Exception{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
