package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/02
 */
public class OrderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //监听服务的启动:
        System.out.println("项目启动");
        ServletContext context = servletContextEvent.getServletContext();
    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("项目停止");
    }
}
