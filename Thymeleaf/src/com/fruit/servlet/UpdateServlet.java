package com.fruit.servlet;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.impl.FruitDAOImpl;
import com.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @class description:
 * @author:杨安益
 * @date:2022/9/12 14:34
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //为了检索表单数据，可使用getParameter（）方法。
        logger.warn("request ==> {}", req.getRequestURI());
        //1 设置编码
        req.setCharacterEncoding("utf-8");

        //2 获取参数
        String fid1 = req.getParameter("fid");
        String fname = req.getParameter("fname");
        String price = req.getParameter("price");
        String fcount1 = req.getParameter("fcount");
        if (StringUtil.isEmpty(fname)) {
            throw new ServletException("name 为空");
        }
        if (StringUtil.isEmpty(fid1)) {
            throw new ServletException("fid1 为空");
        }
        if (StringUtil.isEmpty(price)) {
            throw new ServletException("price 为空");
        }
        if (StringUtil.isEmpty(fcount1)) {
            throw new ServletException("fcount1 为空");
        }
        Integer fid = Integer.parseInt(fid1);
        Integer prcie = Integer.parseInt(price);
        Integer fcount = Integer.parseInt(fcount1);
        String remark = req.getParameter("remark");
        //3 执行跟新
        fruitDAO.updateFruit(new Fruit(fid, fname, prcie, fcount, remark));
        //4 资源跳转
        logger.warn("资源跳转");
        super.processTemplate("index", req, resp);
    }
}
