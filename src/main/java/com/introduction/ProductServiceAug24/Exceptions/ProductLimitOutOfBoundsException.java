package com.introduction.ProductServiceAug24.Exceptions;

public class ProductLimitOutOfBoundsException extends Exception{
    public ProductLimitOutOfBoundsException(String msg) {
        super(msg);
    }
}
