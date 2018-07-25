/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/13
 */
public class Main {

    public static  void main(String args []){

        ProxyHandler proxyHandler = new ProxyHandler();
        proxyHandler.setProxyObject(new ProxyObject());
        IProxy proxy = (IProxy)proxyHandler.getProxyInstance();
        proxy.sell();

    }
}
