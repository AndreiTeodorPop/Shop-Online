package com.shop.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Checks when a client try to access protectPage without authorization
 * And redirect it to loginPage
 */
public class ProtectedFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtectedFilter.class);
    public static final String SHOP_LOGIN_PAGE = "/shop/login";
    public static final String SHOP_PROTECT_PAGE = "/shop/protect";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Initiating Protected Page Filter");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        LOGGER.info("This Filter is only called when request is mapped for /protect resource");

        String uri = request.getRequestURI();

        if(uri.matches(SHOP_PROTECT_PAGE)) {
            response.sendRedirect(SHOP_LOGIN_PAGE);
        }else {
            chain.doFilter(req, res);
            LOGGER.info("Logging Response :{}", request.getContentType());
        }

    }

    @Override
    public void destroy() {}
}

