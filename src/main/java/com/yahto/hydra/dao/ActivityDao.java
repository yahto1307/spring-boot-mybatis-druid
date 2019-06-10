package com.yahto.hydra.dao;

import com.yahto.hydra.model.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by yahto on 2019-05-28 11:07
 *
 * @author yahto
 */
@Repository
public interface ActivityDao {
    /**
     * insert activity model
     *
     * @param activity model
     * @return entity
     */
    int insertSelective(Activity activity);
}
