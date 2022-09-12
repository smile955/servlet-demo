package com.Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @class description:
 * @author:杨安益
 * @date:2022/9/11 14:36
 */
@WebServlet("/demo02")
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 获取request保存作用域保存的数据,key为uname
        Object uname = req.getAttribute("uname");
        //日志
        Logger logger = LoggerFactory.getLogger(this.getClass());
        System.out.println(logger);
        System.out.println("demo02=" + uname);
    }
}
