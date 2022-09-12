package com.fruit.dao;

import com.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();

    //根据fid获取特定的水果库存信息
    Fruit getFruitById(Integer fid);

    //修改指定fid的库存记录
    void updateFruit(Fruit fruit);

}
