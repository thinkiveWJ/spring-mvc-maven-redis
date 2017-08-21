package beacool.test;

import beacool.controller.LoginController;
import beacool.service.redis.RedisCacheService;
import beacool.util.PublicKeyUtil;
import beacool.util.RSAUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/21.
 */
public class TestGetRSAPublicKey extends BaseTest {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private RedisCacheService redisCacheService;

    @Test
    public void getRSAPublicKey(){
        PublicKeyUtil publicKeyMap = RSAUtil.getInstance("123").getPublicKeyUtil(true);
    }
}
