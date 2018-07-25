package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order")
/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/02
 */
public class JamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread()+" start.....");
        try {
            buyCards();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("order success");
        //super.doGet(req, resp);
    }

    public void buyCards() throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread.sleep(5000); //模拟业务操作


    }


}
