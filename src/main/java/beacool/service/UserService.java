package beacool.service;

import beacool.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface  UserService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public List<User> findByUsernameAndPwd(String username, String password, int currentNum, int pageSize);
}
