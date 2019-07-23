package com.yahto.hydra.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yahto on 2019-06-11 17:18
 *
 * @author yahto
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_kill_item")
public class KillItem {
    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "activity_id")
    private Long activityId;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "total_count")
    private Long totalCount;
    @JSONField(name = "left_count")
    private Long leftCount;
    @JSONField(name = "create_at")
    private Date createAt;
    @JSONField(name = "update_at")
    private Date updateAt;
}
