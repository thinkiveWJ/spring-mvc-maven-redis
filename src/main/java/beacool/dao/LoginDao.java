package beacool.dao;

import beacool.entity.Login;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface LoginDao {
    List<Login> queryLogin(Login login);
}
