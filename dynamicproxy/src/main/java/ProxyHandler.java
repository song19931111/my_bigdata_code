import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/13
 */
public class ProxyHandler implements InvocationHandler {
    private  Object proxyObject;//动态代理的对象

    public Object getProxyObject() {
        return proxyObject;
    }

    public void setProxyObject(Object proxyObject) {
        this.proxyObject = proxyObject;
    }
    public Object getProxyInstance(){
        Object newProxyInstance = Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), proxyObject.getClass().getInterfaces(), this);
        return newProxyInstance;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(proxyObject, args);
        after();
        return ret;
    }
    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}
