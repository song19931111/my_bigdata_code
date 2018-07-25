package servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/asynOrder",asyncSupported = true)
/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/02
 */
public class OrderAsynServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("主线程"+Thread.currentThread()+" start....."+System.currentTimeMillis());
        AsyncContext startASyn =req.startAsync();

        startASyn.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("异步线程"+Thread.currentThread()+" start....."+System.currentTimeMillis());
                    buyCards();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {

                    //拿到异步容器
                    AsyncContext asyncContext = req.getAsyncContext();
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("order success");
                    //通知异步完成
                    startASyn.complete();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("异步线程"+Thread.currentThread()+" end....."+System.currentTimeMillis());
                //super.doGet(req, resp);

            }
        });
        System.out.println("主线程"+Thread.currentThread()+" end....."+System.currentTimeMillis());

    }

    public void buyCards() throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread.sleep(5000); //模拟业务操作


    }


}
