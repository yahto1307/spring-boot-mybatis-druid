package com.yahto.hydra.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by yahto on 2019-05-27 17:01
 *
 * @author yahto
 */
@Data
@Builder
public class Activity {
    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "create_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @JSONField(name = "update_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

}