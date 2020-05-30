//package com.yahto.hydra.dao.provider;
//
//import com.google.common.base.Strings;
//import com.yahto.hydra.dao.condition.ActivityQueryCondition;
//import com.yahto.hydra.model.Activity;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.jdbc.SQL;
//
///**
// * Created by yahto on 2019-06-11 10:55
// *
// * @author yahto
// */
//public class ActivitySqlProvider {
//
//    public String insertEntity(Activity activity) {
//        return new SQL() {{
//            INSERT_INTO("tb_activity");
//            if (!Strings.isNullOrEmpty(activity.getName())) {
//                VALUES("name", "#{name,jdbcType=VARCHAR}");
//            }
//            if (activity.getCreateAt() != null) {
//                VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
//            }
//            if (activity.getUpdateAt() != null) {
//                VALUES("update_at", "#{updateAt,jdbcType=TIMESTAMP}");
//            }
//        }}.toString();
//    }
//
//
//    public String queryByCondition(@Param("condition") ActivityQueryCondition condition) {
//        return new SQL() {{
//            SELECT("ta.id,ta.name,ta.create_at,ta.update_at")
//                    .FROM("tb_activity as ta");
//            if (!condition.isNull()) {
//                if (condition.getId() != null) {
//                    WHERE("ta.id = #{condition.id,jdbcType=BIGINT}");
//                }
//                if (!Strings.isNullOrEmpty(condition.getName())) {
//                    WHERE("ta.name = #{condition.name,jdbcType=VARCHAR}");
//                }
//            }
//        }}.toString();
//    }
//
//    public String queryAll(@Param("activityId") Long activityId) {
//        return new SQL() {{
//            SELECT("ta.id activity_id,ta.name activity_name,ta.create_at activity_create_at,ta.update_at activity_update_at," +
//                    "tk.id kill_item_id,tk.name kill_item_name,tk.total_count kill_item_total_count,tk.left_count kill_item_left_count,tk.create_at kill_item_create_at,tk.update_at kill_item_update_at")
//                    .FROM("tb_kill_item tk")
//                    .INNER_JOIN("tb_activity ta on tk.activity_id=ta.id")
//                    .WHERE("ta.id = #{activityId,jdbcType=BIGINT}");
//        }}.toString();
//    }
//}
