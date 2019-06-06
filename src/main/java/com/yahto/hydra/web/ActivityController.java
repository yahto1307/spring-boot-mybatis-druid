package com.yahto.hydra.web;

import com.yahto.hydra.dao.ActivityDao;
import com.yahto.hydra.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yahto on 2019-05-28 11:29
 *
 * @author yahto
 */
@RestController("/activity")
public class ActivityController {
    @Autowired
    private ActivityDao activityDao;

    @GetMapping
    @ResponseBody
    public String create() {
        Activity activity = Activity.builder()
                .name("hail hydra")
                .build();
        activityDao.insertSelective(activity);
        return activity.toString();
    }
}
