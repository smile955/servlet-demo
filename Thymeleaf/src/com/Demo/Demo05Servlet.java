package com.Demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @class description:
 * @author:杨安益
 * @date:2022/9/11 15:40
 */
@WebServlet("/demo05")
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向application保存作用域保存数据


// ServletContext:Servlet上下文
        ServletContext application = req.getServletContext();
        application.setAttribute("uname", "lili");
//  等于      req.getServletContext().setAttribute("uname","lili");\


        //客户端重定向
        resp.sendRedirect("demo06");
    }
}
