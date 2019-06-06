package com.yahto.hydra.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * Created by yahto on 2019-06-06 14:18
 *
 * @author yahto
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private Meta meta;
    private Map<String, Object> data = Maps.newHashMap();

    public Result success() {
        this.meta = new Meta(true, "success");
        return this;
    }

    public Result success(Map<String, Object> data) {
        this.meta = new Meta(true, "success");
        this.data.putAll(data);
        return this;
    }

    public Result add(String key, Object data) {
        this.data.put(key, data);
        return this;
    }

    public Result fail(String msg) {
        this.meta = new Meta(false, msg);
        return this;
    }

    public Result exception(String msg, Throwable ex) {
        this.meta = new Meta(false, msg);
        this.data.put("cause", ex.getLocalizedMessage());
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
        private DateTime timestamp;

        public Meta(boolean success) {
            this.success = success;
            this.timestamp = DateTime.now();
        }

        Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
            this.timestamp = DateTime.now();
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public DateTime getTimestamp() {
            return timestamp;
        }
    }
}
