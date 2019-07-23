package com.yahto.hydra.model.result;

import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Map;

/**
 * Created by yahto on 2019-06-06 14:18
 *
 * @author yahto
 */
public class Result<T> {
    private Meta meta;
    private Map<String, T> data = Maps.newHashMap();

    public Result success() {
        this.meta = new Meta(true, "success");
        return this;
    }

    public Result<T> success(Map<String, T> data) {
        this.meta = new Meta(true, "success");
        this.data.putAll(data);
        return this;
    }

    public Result<T> add(String key, T data) {
        this.data.put(key, data);
        return this;
    }

    public Result fail(String msg) {
        this.meta = new Meta(false, msg);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public class Meta {

        private boolean success;
        private String message;
        private Date timestamp;

        public Meta(boolean success) {
            this.success = success;
            this.timestamp = DateTime.now().toDate();
        }

        Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
            this.timestamp = DateTime.now().toDate();
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public Date getTimestamp() {
            return timestamp;
        }
    }
}
