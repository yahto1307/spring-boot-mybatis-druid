package com.yahto.hydra.web;

import com.yahto.hydra.dao.ActivityDao;
import com.yahto.hydra.dao.condition.ActivityQueryCondition;
import com.yahto.hydra.exception.BaseException;
import com.yahto.hydra.exception.ExceptionEnum;
import com.yahto.hydra.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 2019-05-28 11:29
 *
 * @author yahto
 */
@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityDao activityDao;

    @GetMapping("/create")
    public Activity create() {
        Activity activity = Activity.builder()
                .createAt(new Date())
                .updateAt(new Date())
                .name("hail hydra")
                .build();
        activityDao.insertSelective(activity);
        return activity;
    }

    @GetMapping("/query")
    public List<Activity> query() {
        ActivityQueryCondition condition = new ActivityQueryCondition();
        throw BaseException.builder().exceptionEnum(ExceptionEnum.DATABASE_EXCEPTION).build();
//        return activityDao.queryByCondition(condition);
    }
}
