package com.Demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @class description:
 * @author:杨安益
 * @date:2022/9/11 14:33
 */
//演示request保存作用域(demo01和demo02)
@WebServlet("/demo01")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 向request保存作用域保存数据
        req.setAttribute("uname", "lili");

//        2 客户端重定向
//        resp.sendRedirect("demo02");

        //3.服务器端转发
        req.getRequestDispatcher("demo02").forward(req, resp);

    }
}
