package servlet;

import services.OrderService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/02
 */


@HandlesTypes(value = OrderService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        for(Class<?> tClass :set){
            System.out.println(tClass.getName());
        }
        //Ìí¼Ófilter ,À¹½Øservlet:
        FilterRegistration.Dynamic orderFilter = servletContext.addFilter("OrderFilter", OrderFilter.class);
        orderFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");


        servletContext.addListener(OrderListener.class);


        ServletRegistration.Dynamic orderSevlet = servletContext.addServlet("OrderSevlet", OrderServlet.class);
        orderSevlet.addMapping("/order2");


    }
}
