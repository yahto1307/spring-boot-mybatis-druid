//package com.yahto.hydra.dao;
//
//import com.yahto.hydra.dao.condition.ActivityQueryCondition;
//import com.yahto.hydra.dao.provider.ActivitySqlProvider;
//import com.yahto.hydra.model.Activity;
//import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.type.JdbcType;
//import org.springframework.stereotype.Repository;
//import tk.mybatis.mapper.common.ConditionMapper;
//
//import java.util.List;
//
///**
// * Created by yahto on 2019-05-28 11:07
// *
// * @author yahto
// */
//@Repository
//public interface ActivityDao extends tk.mybatis.mapper.common.Mapper<Activity>, ConditionMapper<Activity> {
//    /**
//     * insert activity model
//     *
//     * @param activity model
//     * @return entity
//     */
//    @InsertProvider(type = ActivitySqlProvider.class, method = "insertEntity")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    int insertEntity(Activity activity);
//
//
//    /**
//     * query by condition entity
//     *
//     * @param condition condition
//     * @return list of entity
//     */
//    @Results(id = "activityBaseMap", value = {
//            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT),
//            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
//            @Result(property = "createAt", column = "create_at", jdbcType = JdbcType.TIMESTAMP),
//            @Result(property = "updateAt", column = "update_at", jdbcType = JdbcType.TIMESTAMP),
//    })
//    @SelectProvider(type = ActivitySqlProvider.class, method = "queryByCondition")
//    List<Activity> queryByCondition(@Param("condition") ActivityQueryCondition condition);
//}
