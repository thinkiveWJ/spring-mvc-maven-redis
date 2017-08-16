package beacool.controller;

import beacool.entity.User;
import beacool.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/find")
    @ResponseBody
    public Map<String,Object> find(User user, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charse=UTF-8");
        Map<String,Object> map = new HashedMap();
        System.out.println("你已通过springMVC进入controller方法。。。。");
        logger.info("你已通过springMVC进入controller方法。。。。");
        String name = user.getUsername();
        String password = user.getPassword();
//        int currentPage = user.getPageNum();
//        int pageSize = user.getPageSize();
//        int totalPage = user.getTotalPage();
//        currentPage = currentPage > 0 ? currentPage : 1;
//        int currentNum = (currentPage - 1)*pageSize + 1;
//        if(StringUtils.isBlank(name)){
//            map.put("message","用户名不能为空");
//            return map;
//        }
//        List<User> users = userService.findByUsernameAndPwd(name, password, currentNum, pageSize);
//        map.put("data",users);
//        if(users != null){
//            map.put("result","success");
//        }else {
//            map.put("result","失败");
//        }
        return map;
    }
}
