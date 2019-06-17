package com.yahto.hydra.dao;

import com.yahto.hydra.dao.condition.ActivityQueryCondition;
import com.yahto.hydra.dao.provider.ActivitySqlProvider;
import com.yahto.hydra.model.Activity;
import com.yahto.hydra.model.KillItemWithActivity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ConditionMapper;

import java.util.List;

/**
 * Created by yahto on 2019-05-28 11:07
 *
 * @author yahto
 */
@Repository
public interface ActivityDao extends tk.mybatis.mapper.common.Mapper<Activity> , ConditionMapper<Activity> {
    /**
     * insert activity model
     *
     * @param activity model
     * @return entity
     */
    @InsertProvider(type = ActivitySqlProvider.class, method = "insertEntity")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEntity(Activity activity);


    /**
     * query by condition entity
     *
     * @param condition condition
     * @return list of entity
     */
    @Results(id = "activityBaseMap", value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "createAt", column = "create_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "updateAt", column = "update_at", jdbcType = JdbcType.TIMESTAMP),
    })
    @SelectProvider(type = ActivitySqlProvider.class, method = "queryByCondition")
    List<Activity> queryByCondition(@Param("condition") ActivityQueryCondition condition);

    /**
     * inner join all columns
     *
     * @param activityId activity id
     * @return list of entity
     */
    @Results(id = "killItemWithActivityBaseMap", value = {
            @Result(property = "killItemId", column = "kill_item_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "activityId", column = "activity_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "killItemName", column = "kill_item_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "activityName", column = "activity_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "totalCount", column = "kill_item_total_count", jdbcType = JdbcType.INTEGER),
            @Result(property = "leftCount", column = "kill_item_left_count", jdbcType = JdbcType.INTEGER),
            @Result(property = "killItemCreateAt", column = "kill_item_create_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "activityCreateAt", column = "activity_create_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "killItemUpdateAt", column = "kill_item_update_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "activityUpdateAt", column = "activity_update_at", jdbcType = JdbcType.TIMESTAMP),
    })
    @SelectProvider(type = ActivitySqlProvider.class, method = "queryAll")
    List<KillItemWithActivity> queryAll(@Param("activityId") Long activityId);
}
