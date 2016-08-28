package ssm.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.pojo.User;
import ssm.service.IUserService;



/**
 * Created by heisenberg on 16-8-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {

    Logger logger = LoggerFactory.getLogger(TestMybatis.class);

    @Autowired
    IUserService userService;

    @Test
    public void test(){
        User user = userService.getUserById(1);
        logger.info(user.getName() +" "+ user.getSexy() + " " + user.getAge());

    }
}
