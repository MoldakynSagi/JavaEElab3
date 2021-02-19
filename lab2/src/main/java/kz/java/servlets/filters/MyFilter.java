package kz.java.servlets.filters;

import kz.java.DataBase;
import kz.java.user;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        boolean j = false;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<DataBase> data = (AtomicReference<DataBase>) req.getServletContext().getAttribute("data");

        final HttpSession session = req.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            final user.NAME name = (user.NAME) session.getAttribute("name");
            menu(req, res, name);
            j = false;
        } else if (j == false) {

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);

            menu(req, res, user.NAME.Sagi);

        } else {
            menu(req, res, user.NAME.UNK);
        }
    }

    public void menu(final HttpServletRequest req,
                     final HttpServletResponse res,
                     final user.NAME name)
            throws ServletException, IOException {

        if (name.equals(user.NAME.Sagi)) {
            req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, res);
        } else if (name.equals(user.NAME.Adam)) {
            req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }

    }

    @Override
    public void destroy() {

    }
}
