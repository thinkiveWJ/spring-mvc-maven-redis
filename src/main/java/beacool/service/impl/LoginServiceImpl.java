package beacool.service.impl;

import beacool.dao.LoginDao;
import beacool.entity.Login;
import beacool.service.error.ErrorExceptionService;
import beacool.service.LoginService;
import beacool.service.redis.RedisCacheService;
import beacool.util.MD5;
import beacool.util.RSAUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private RedisCacheService redisCacheService;

    public Map<String, Object> queryLogin(Login login) {
        ErrorExceptionService errorExceptionService = new ErrorExceptionService();
        Map<String, Object> map = new HashedMap();
        String userName = login.getUserName();
        String password = login.getPassword();
        logger.error("【login.do params】############################入参信息:" + login);
        if (userName == null || userName.isEmpty()) {
            map.put("errorCode", -1);
            map.put("msg", "用户名不能为空！");
            return map;
        }
        if (password == null || password.isEmpty()) {
            map.put("errorCode", -1);
            map.put("msg", "用户密码不能为空！");
            return map;
        }
        password = RSAUtil.getInstance(userName).decryptStringByJs(password);
        try {
            password = MD5.getMd5(password);
        } catch (Exception e) {
            errorExceptionService.setErrorCode(-1);
            errorExceptionService.setMsg("md5加密失败");
            logger.error("【Exception】========异常信息:"+ e);
        }
        login.setPassword(password);

        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!"+login.getPassword());
        List<Login> list = new ArrayList<Login>();
        try{
            list = loginDao.queryLogin(login);
            if(list == null || list.isEmpty()){
                errorExceptionService.setErrorCode(-1);
                errorExceptionService.setMsg("账号或密码错误！");
            }else{
                String token = redisCacheService.generateToken(login.getUserName());
                login.setToken(token);
            }
        }catch (Exception e){
            errorExceptionService.setErrorCode(1003);
            logger.error("【Exception】========异常信息:"+ e);
        }
        for(Login item: list){
            item.setToken(login.getToken());
            map.put("data", item);
        }
        map.put("errorCode", errorExceptionService.getErrorCode());
        map.put("msg", errorExceptionService.getMsg());
        logger.error("【login.do result】###########################返回数据：" + map);
        return map;
    }
}

