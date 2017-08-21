package beacool.controller;

import beacool.entity.Login;
import beacool.param.PatientTempParam;
import beacool.service.LoginService;
import beacool.service.PatientTempService;
import beacool.service.impl.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "queryLogin.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryLogin(Login login, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charse=UTF-8");
        return loginService.queryLogin(login);
    }
}
