package com.example.CourseWork4.main.repository;

import com.example.CourseWork4.main.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Optional;

public interface SaleRepository extends CrudRepository<Sales, Integer>
{
    Optional<Sales> findById(Integer id);
    Optional<Sales> findByGoodID(Integer goodId);
    Iterable<Sales> findByGoodCount(Integer goodCount);
    Iterable<Sales> findByCreateData(Timestamp createData);

    Iterable<Sales> findAll();

    @Query("SELECT s FROM Sales s " +
            "JOIN Goods g " +
            "ON s.goodId = g " +
            "WHERE g.name = :name")
    Iterable<Sales> findSaleByName(@Param("name") String name);

    @Query("SELECT s FROM Sales s " +
            "JOIN Goods g " +
            "ON s.goodId = g " +
            "WHERE g.priority = :priority")
    Iterable<Sales> findSaleByPriority(@Param("priority") Float priority);

    @Modifying
    @Transactional
    @Query("UPDATE Sales s " +
            "SET s.goodCount = :newGoodCount " +
            "WHERE s.id = :id")
    void updateSale(
            @Param("id") Integer id,
            @Param("newGoodCount") Integer newGoodCount);

    @Transactional
    void deleteSaleById(Integer id);
}
