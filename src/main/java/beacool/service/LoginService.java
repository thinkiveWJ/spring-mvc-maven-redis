package beacool.service;

import beacool.entity.Login;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface LoginService {
    public Map<String, Object> queryLogin(Login login);
}
