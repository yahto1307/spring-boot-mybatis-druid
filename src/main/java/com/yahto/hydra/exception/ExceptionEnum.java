package com.yahto.hydra.exception;

/**
 * Created by yahto on 2019-06-11 14:55
 *
 * @author yahto
 */
public enum ExceptionEnum {
    //**httpCode=500 exceptions
    DATABASE_EXCEPTION(5001, 500, "database exception");

    private Integer serviceExceptionCode;
    private Integer httpCode;
    private String message;

    ExceptionEnum(Integer serviceExceptionCode, Integer httpCode, String message) {
        this.serviceExceptionCode = serviceExceptionCode;
        this.httpCode = httpCode;
        this.message = message;
    }

    public Integer getServiceExceptionCode() {
        return serviceExceptionCode;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ExceptionEnum{" +
                "serviceExceptionCode=" + serviceExceptionCode +
                ", httpCode=" + httpCode +
                ", message='" + message + '\'' +
                '}';
    }
}
