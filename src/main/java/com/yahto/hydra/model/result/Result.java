package com.yahto.hydra.model.result;

import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by yahto on 2019-06-06 14:18
 *
 * @author yahto
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Meta meta;
    private T data;

    public Result<T> success() {
        this.meta = new Meta(true, "success");
        return this;
    }

    public Result<T> success(T data) {
        this.meta = new Meta(true, "success");
        this.data = data;
        return this;
    }

    public Result<T> fail(String msg) {
        this.meta = new Meta(false, msg);
        return this;
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
