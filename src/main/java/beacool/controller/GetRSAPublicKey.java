package beacool.controller;


import beacool.entity.Login;
import beacool.service.error.ErrorExceptionService;
import beacool.service.redis.RedisCacheService;
import beacool.util.PublicKeyUtil;
import beacool.util.RSAUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/18.
 */
@Controller
@RequestMapping("/RSA")
public class GetRSAPublicKey {
    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "getRSAPublicKey.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getRSAPublicKey(Login login, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charse=UTF-8");
        logger.error("【getRSAPublicKey.do】###########################入参：" + login);
        ErrorExceptionService errorExceptionService = new ErrorExceptionService();
        Map<String, Object> map = new HashedMap();
        String username  = login.getUserName();
        PublicKeyUtil publicKeyMap = new PublicKeyUtil();
        if(username == null || username.isEmpty()){
            map.put("data", publicKeyMap);
            map.put("errorCode", -1);
            map.put("msg", "获取秘钥对失败");
            logger.error("【getRSAPublicKey.do】###########################出参：" + map);
            return map;
        }
        publicKeyMap = RSAUtil.getInstance(username).getPublicKeyUtil(true);
        map.put("data", publicKeyMap);
        map.put("errorCode", errorExceptionService.getErrorCode());
        map.put("msg", errorExceptionService.getMsg());
        logger.error("【getRSAPublicKey.do】###########################出参：" + map);
        return map;
    }
}
