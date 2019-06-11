package com.yahto.hydra.dao.condition;

import lombok.Data;

import java.util.Date;

/**
 * Created by yahto on 2019-06-11 11:27
 *
 * @author yahto
 */
@Data
public class ActivityQueryCondition {
    private Long id;
    private String name;
    private Date createAt;
    private Date updateAt;

    public boolean isNull() {
        return (id == null && name == null && createAt == null && updateAt == null);
    }

}
