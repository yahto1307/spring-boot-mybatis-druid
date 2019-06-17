package com.yahto.hydra.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yahto on 2019-05-27 17:01
 *
 * @author yahto
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_activity")
public class Activity {
    @JSONField(name = "id")
    @Column(name = "id", nullable = false)
    private Long id;

    @JSONField(name = "name")
    @Column(name = "name")
    private String name;

    @JSONField(name = "create_at", format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_at")
    private Date createAt;

    @JSONField(name = "update_at", format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_at")
    private Date updateAt;
}