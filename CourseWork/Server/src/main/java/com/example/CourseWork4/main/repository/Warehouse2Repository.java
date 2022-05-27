package com.example.CourseWork4.main.repository;

import com.example.CourseWork4.main.entities.Warehouse2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Warehouse2Repository extends CrudRepository<Warehouse2, Integer>
{
    Optional<Warehouse2> findById(Integer id);
    Optional<Warehouse2> findByGoodID(Integer goodId);
    Iterable<Warehouse2> findByGoodCount(Integer goodCount);
    Iterable<Warehouse2> findAll();

    @Query("SELECT w2 FROM Warehouse2 w2 " +
            "JOIN Goods g " +
            "ON w2.goodFromWHSecondId = g " +
            "WHERE g.name = :name")
    Iterable<Warehouse2> findGoodFromWHSecondByName(@Param("name") String name);

    @Query("SELECT w2 FROM Warehouse2 w2 " +
            "JOIN Goods g " +
            "ON w2.goodFromWHSecondId = g " +
            "WHERE g.priority = :priority")
    Iterable<Warehouse2> findGoodFromWHSecondByPriority(@Param("priority") Float priority);
}
