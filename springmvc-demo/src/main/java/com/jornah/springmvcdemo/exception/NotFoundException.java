package com.jornah.springmvcdemo.exception;

import java.util.Arrays;

public class NotFoundException extends BaseBusinessException {

    public NotFoundException(BusinessCode businessCodeCode, String msgCode) {
        this(businessCodeCode, msgCode, null);
    }

    public NotFoundException(BusinessCode businessCodeCode, String msgCode, Object[] arguments) {
        super(businessCodeCode, msgCode, arguments);
    }

    @Override
    public String toString() {
        return "NotFoundException{" +
                "businessErrorCode='" + businessCodeCode + '\'' +
                ", msgCode='" + msgCode + '\'' +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
