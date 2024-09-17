package com.scaler.productservicejune24.exceptions;

public class ProductNotFoundException extends Exception{
    public Long productid;

    public ProductNotFoundException(Long productid) {
        //super(message);
        this.productid = productid;

    }

    public Long getProductid() {
        return productid;
    }

}
