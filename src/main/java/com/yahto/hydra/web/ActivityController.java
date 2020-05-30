//package com.yahto.hydra.web;
//
//import com.google.common.collect.Lists;
//import com.yahto.hydra.dao.ActivityDao;
//import com.yahto.hydra.model.Activity;
//import com.yahto.hydra.model.result.Result;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import tk.mybatis.mapper.entity.Condition;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by yahto on 2019-05-28 11:29
// *
// * @author yahto
// */
//@RestController
//@RequestMapping("activity")
//public class ActivityController {
//    @Autowired
//    private ActivityDao activityDao;
//
//    @ApiOperation(value = "create activity", notes = "create activity")
//    @GetMapping("/create")
//    public Result<Activity> create() {
//        Activity activity = Activity.builder()
//                .createAt(new Date())
//                .updateAt(new Date())
//                .name("hail hydra")
//                .build();
//        activityDao.insertSelective(activity);
//        return new Result<Activity>().success(activity);
//    }
//
//    @GetMapping("/query")
//    public Result<List<Activity>> query() {
//        Condition activityCondition = new Condition(Activity.class);
//        activityCondition.createCriteria();
//        List<Long> excludeIds = Lists.newArrayList();
//        excludeIds.add(1L);
//        activityCondition.createCriteria().andNotIn("id", excludeIds);
//        return new Result<List<Activity>>().success(activityDao.selectByCondition(activityCondition));
//    }
//
//    @GetMapping("/hello")
//    public String hello() {
//       return "hello";
//    }
//
//}
