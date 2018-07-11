package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/02
 */
public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Order Filter Start");
        //·ÅÐÐ
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
