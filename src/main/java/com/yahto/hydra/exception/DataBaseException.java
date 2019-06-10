package com.yahto.hydra.exception;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by yahto on 2019-06-06 14:12
 *
 * @author yahto
 */
public class DataBaseException extends BaseException {
    public DataBaseException(Integer status, String msg, Date timestamp) {
        super(status, msg, timestamp);
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public DataBaseException(Integer status, String msg) {
        super(msg);
        this.status = status;
        this.msg = msg;
        this.timestamp = DateTime.now().toDate();
    }

    public DataBaseException(String msg) {
        super(msg);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.msg = msg;
        this.timestamp = DateTime.now().toDate();
    }
}
