package beacool.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

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
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
