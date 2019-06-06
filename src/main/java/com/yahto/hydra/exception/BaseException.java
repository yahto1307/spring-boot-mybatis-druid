package com.yahto.hydra.exception;

import org.joda.time.DateTime;

/**
 * Created by yahto on 2019-06-06 13:58
 *
 * @author yahto
 */
public abstract class BaseException extends RuntimeException {
    Integer status;
    String msg;
    DateTime timestamp;

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }


    public BaseException(Integer status, String msg, DateTime timestamp) {
        super(msg);
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public BaseException(Throwable cause, Integer status, String msg, DateTime timestamp) {
        super(msg, cause);
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public BaseException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer status, String msg, DateTime timestamp) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }
}
