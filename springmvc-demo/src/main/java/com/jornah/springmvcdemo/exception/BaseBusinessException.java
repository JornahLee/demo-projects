package com.jornah.springmvcdemo.exception;

public class BaseBusinessException extends RuntimeException {
    protected BusinessCode businessCodeCode;
    protected String msgCode = "";
    protected Object[] arguments = null;


    public BaseBusinessException(BusinessCode businessCodeCode, String msgCode) {
        this(businessCodeCode, msgCode, null);
    }

    public BaseBusinessException(BusinessCode businessCodeCode, String msgCode, Object[] arguments) {
        this.businessCodeCode = businessCodeCode;
        this.msgCode = msgCode;
        this.arguments = arguments;
    }

}
