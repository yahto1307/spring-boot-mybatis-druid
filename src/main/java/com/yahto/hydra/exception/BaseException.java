package com.yahto.hydra.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yahto on 2019-06-06 13:58
 *
 * @author yahto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private Integer status;
    private String message;

    private BaseException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getHttpCode();
        this.message = exceptionEnum.getMessage();
    }

    private BaseException(String message, Throwable cause, Integer status) {
        super(message, cause);
        this.status = status;
        this.message = message;
    }

    private BaseException(String message,
                          Integer status,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.message = message;
    }

    public static BaseExceptionBuilder builder() {
        return new BaseExceptionBuilder();
    }

    public static class BaseExceptionBuilder {
        private ExceptionEnum exceptionEnum;
        private Throwable cause;
        private Boolean enableSuppression;
        private Boolean writableStackTrace;

        public BaseExceptionBuilder() {
        }

        public BaseExceptionBuilder exceptionEnum(final ExceptionEnum exceptionEnum) {
            this.exceptionEnum = exceptionEnum;
            return this;
        }

        public BaseExceptionBuilder cause(final Throwable cause) {
            this.cause = cause;
            return this;
        }

        public BaseExceptionBuilder enableSuppression(final boolean enableSuppression) {
            this.enableSuppression = enableSuppression;
            return this;
        }

        public BaseExceptionBuilder writableStackTrace(final boolean writableStackTrace) {
            this.writableStackTrace = writableStackTrace;
            return this;
        }

        public BaseException build() {
            if (this.exceptionEnum == null) {
                throw new RuntimeException("exceptionEnum can not be null,build exception exception");
            }
            if (this.cause == null) {
                return new BaseException(this.exceptionEnum);
            } else {
                if (this.enableSuppression == null || this.writableStackTrace == null) {
                    return new BaseException(this.exceptionEnum.getMessage(),
                            this.cause, this.exceptionEnum.getHttpCode());
                } else {
                    return new BaseException(this.exceptionEnum.getMessage(),
                            this.exceptionEnum.getHttpCode(),
                            this.cause,
                            this.enableSuppression,
                            this.writableStackTrace);
                }
            }
        }

        @Override
        public String toString() {
            return "BaseExceptionBuilder{" +
                    "exceptionEnum=" + exceptionEnum +
                    ", cause=" + cause +
                    ", enableSuppression=" + enableSuppression +
                    ", writableStackTrace=" + writableStackTrace +
                    '}';
        }
    }

}
