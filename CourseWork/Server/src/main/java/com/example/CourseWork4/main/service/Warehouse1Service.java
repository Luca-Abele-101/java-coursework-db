package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.entities.Warehouse1;

import java.util.List;

public interface Warehouse1Service
{
    Warehouse1 findById(Integer id);
    Warehouse1 findByGoodID(Integer goodId);
    List<Warehouse1> findByGoodCount(Integer goodCount);

    List<Warehouse1> findAll();

    List<Warehouse1> findGoodFromWHFirstByName(String name);
    List<Warehouse1> findGoodFromWHFirstByPriority(Float priority);

}
