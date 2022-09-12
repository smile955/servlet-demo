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
 * @date:2022/9/11 15:26
 */
@WebServlet("/demo04")
public class Demo04Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session作用域保存的数据 k为uname
        Object uname = req.getSession().getAttribute("uname");
        System.out.println(uname);
    }
}
