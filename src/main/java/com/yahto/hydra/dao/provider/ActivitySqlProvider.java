package com.yahto.hydra.dao.provider;

import com.google.common.base.Strings;
import com.yahto.hydra.dao.condition.ActivityQueryCondition;
import com.yahto.hydra.model.Activity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by yahto on 2019-06-11 10:55
 *
 * @author yahto
 */
public class ActivitySqlProvider {

    public String insertSelective(Activity activity) {
        return new SQL() {{
            INSERT_INTO("tb_activity");
            if (!Strings.isNullOrEmpty(activity.getName())) {
                VALUES("name", "#{name,jdbcType=VARCHAR}");
            }
            if (activity.getCreateAt() != null) {
                VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
            }
            if (activity.getUpdateAt() != null) {
                VALUES("update_at", "#{updateAt,jdbcType=TIMESTAMP}");
            }
        }}.toString();
    }


    public String queryByCondition(@Param("condition") ActivityQueryCondition condition) {
        return new SQL() {{
            SELECT("ta.id,ta.name,ta.create_at,ta.update_at");
            FROM("tb_activity as ta");
            if (!condition.isNull()) {
                if (condition.getId() != null) {
                    WHERE("ta.id = #{condition.id,jdbcType=BIGINT}");
                }
                if (!Strings.isNullOrEmpty(condition.getName())) {
                    WHERE("ta.name = #{condition.name,jdbcType=VARCHAR}");
                }
            }
        }}.toString();
    }
}
