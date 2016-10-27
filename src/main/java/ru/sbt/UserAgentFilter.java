package ru.sbt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by user18 on 27.10.2016.
 */
@WebFilter(filterName = "UserAgentFilter")
public class UserAgentFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String userAgent = ((HttpServletRequest) req).getHeader("User-Agent");
        StatisticUserAgent.statistic(userAgent.substring(0, userAgent.indexOf("/")));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
