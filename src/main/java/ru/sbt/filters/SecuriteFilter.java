package ru.sbt.filters;

import ru.sbt.dao.UserDao;
import ru.sbt.dao.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user18 on 27.10.2016.
 */
@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/hello", "/cal"})
public class SecuriteFilter implements Filter {
    private final UserDao userDao = new UserDaoImpl();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession();
        if (session.getAttribute("authenticated") != null) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
