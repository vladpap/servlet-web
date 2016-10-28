package ru.sbt.filters;

import ru.sbt.StatisticUserAgent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by user18 on 27.10.2016.
 */
@WebFilter(filterName = "UserAgentFilter", urlPatterns = "/*")
public class UserAgentFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        StatisticUserAgent.addUserAgent(((HttpServletRequest) req).getHeader("User-Agent"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
