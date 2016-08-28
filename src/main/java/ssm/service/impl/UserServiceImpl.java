package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UserMapper;
import ssm.pojo.User;
import ssm.service.IUserService;

/**
 * Created by heisenberg on 16-8-28.
 */
@Service("IUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
