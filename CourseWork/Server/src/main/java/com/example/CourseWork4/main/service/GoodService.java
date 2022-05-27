package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.dto.GoodsDto;
import com.example.CourseWork4.main.entities.Goods;

import java.util.List;

public interface GoodService
{
    Goods add(GoodsDto goodsDto);
    Goods findById(Integer id);
    Goods findByName(String name);
    List<Goods> findByPriority(Float priority);

    List<Goods> findAll();

    void deleteGoodByName(String name);
}
