package beacool.dao;

import beacool.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
@Repository("userDao")
public interface UserDao {
    public List<User> findByUsernameAndPwd(@Param("username") String username, @Param("password") String password, @Param("currentNum") int currentNum,
                                           @Param("pageSize") int pageSize);
}
