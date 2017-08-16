package beacool.service.impl;

import beacool.dao.UserDao;
import beacool.entity.User;
import beacool.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    public List<User> findByUsernameAndPwd(String name, String pwd, int currentNum, int pageSize) {
        List<User> user = userDao.findByUsernameAndPwd(name, pwd, currentNum, pageSize);
        return user;
    }
}
