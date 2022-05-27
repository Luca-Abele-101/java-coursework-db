package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.entities.Goods;
import com.example.CourseWork4.main.entities.Warehouse2;

import java.util.List;

public interface Warehouse2Service
{
    Warehouse2 findById(Integer id);
    Warehouse2 findByGoodID(Integer goodId);
    List<Warehouse2> findByGoodCount(Integer goodCount);

    List<Warehouse2> findAll();

    List<Warehouse2> findGoodFromWHSecondByName(String name);
    List<Warehouse2> findGoodFromWHSecondByPriority(Float priority);
}
