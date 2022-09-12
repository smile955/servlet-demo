package com.fruit.servlet;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.impl.FruitDAOImpl;
import com.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//servlet从3.0版本开始支持注解方式的注册
@WebServlet(urlPatterns = {"/", "/index"})
//@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        FruitDAO fruitDAO = new FruitDAOImpl();
        //得到一个集合
        List<Fruit> fruitList = fruitDAO.getFruitList();
        System.out.println(fruitList.size());

        //保存到session作用域
        HttpSession session = request.getSession();
        session.setAttribute("fruitList", fruitList);
        Object o = session.getAttribute("fruitList");
        System.out.println(o);

        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html

        super.processTemplate("index", request, response);
    }
}
