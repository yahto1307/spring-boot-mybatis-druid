package com.yahto.hydra.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class Activity {
    @ApiModelProperty(name = "id", value = "0")
    @JSONField(name = "id")
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty(name = "name")
    @JSONField(name = "name")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "create_at", example = "2019-01-01 00:00:00")
    @JSONField(name = "create_at", format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_at")
    private Date createAt;

    @ApiModelProperty(value = "update_at", example = "2019-01-01 00:00:00")
    @JSONField(name = "update_at", format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_at")
    private Date updateAt;
}