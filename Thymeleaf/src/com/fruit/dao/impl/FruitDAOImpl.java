package com.fruit.dao.impl;

import com.fruit.dao.FruitDAO;
import com.fruit.pojo.Fruit;
import com.myssm.basedao.BaseDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Fruit> getFruitList() {
        List<Fruit> fruits = executeQuery("select * from fruit");
        logger.warn("fruits==> {}", fruits);
        return fruits;
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        //问号在这代表占位符
        return super.load("select * from fruit where fid=?", fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update fruit set fname=?,price=?,fcount=?,remark=? where fid=?";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }
}
