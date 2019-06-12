import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yahto.hydra.Application;
import com.yahto.hydra.model.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by yahto on 2019-06-11 16:00
 *
 * @author yahto
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void setTest() {
        Activity activity = Activity.builder()
                .id(1L)
                .name("123活动")
                .updateAt(new Date())
                .createAt(new Date()).build();
        redisTemplate.opsForValue().set("activity", 0.001221);
        Object res =  redisTemplate.opsForValue().get("activity");
        System.out.println(res);
    }
}
