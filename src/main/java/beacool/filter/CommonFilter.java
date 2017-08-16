package beacool.filter;


import beacool.entity.ErrorException;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15.
 */
public class CommonFilter implements Filter {
    private Logger logger = Logger.getLogger(CommonFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURI();
        String token = ((HttpServletRequest) request).getHeader("token");
        if(url.endsWith(".do")){
            if(token == null){
                logger.error("没有token的http请求接口不通过！！！！！！！！！！！！！！");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("{errorCode: 1001, msg: 'token不能为空'}");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
