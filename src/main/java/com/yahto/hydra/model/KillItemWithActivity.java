package com.yahto.hydra.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.Date;

/**
 * Created by yahto on 2019-06-11 17:21
 *
 * @author yahto
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class KillItemWithActivity {
    @JSONField(name = "kill_item_id")
    private Long killItemId;
    @JSONField(name = "activity_id")
    private Long activityId;
    @JSONField(name = "kill_item_name")
    private String killItemName;
    @JSONField(name = "activity_name")
    private String activityName;
    @JSONField(name = "total_count")
    private Long totalCount;
    @JSONField(name = "left_count")
    private Long leftCount;
    @JSONField(name = "kill_item_create_at")
    private Date killItemCreateAt;
    @JSONField(name = "kill_item_update_at")
    private Date killItemUpdateAt;
    @JSONField(name = "activity_create_at")
    private Date activityCreateAt;
    @JSONField(name = "activity_update_at")
    private Date activityUpdateAt;
}
