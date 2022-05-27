package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.dto.SalesDto;
import com.example.CourseWork4.main.entities.Sales;

import java.sql.Timestamp;
import java.util.List;

public interface SaleService
{
    Sales add(SalesDto salesDto);
    Sales addSales(Sales sales);
    Sales findById(Integer id);
    Sales findByGoodID(Integer goodId);
    List<Sales> findByGoodCount(Integer goodCount);
    List<Sales> findByCreateData(Timestamp createData);

    List<Sales> findAll();

    List<Sales> findSaleByName(String name);
    List<Sales> findSaleByPriority(Float priority);

    void updateSale(Integer id, Integer newGoodCount);
    void deleteSaleById(Integer id);
}
