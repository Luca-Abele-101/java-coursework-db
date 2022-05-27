package com.example.CourseWork4.main.repository;

import com.example.CourseWork4.main.entities.Warehouse1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Warehouse1Repository extends CrudRepository<Warehouse1, Integer>
{
    Optional<Warehouse1> findById(Integer id);
    Optional<Warehouse1> findByGoodID(Integer goodId);
    Iterable<Warehouse1> findByGoodCount(Integer goodCount);
    Iterable<Warehouse1> findAll();

    @Query("SELECT w1 FROM Warehouse1 w1 " +
            "JOIN Goods g " +
            "ON w1.goodFromWHFirstId = g " +
            "WHERE g.name = :name")
    Iterable<Warehouse1> findGoodFromWHFirstByName(@Param("name") String name);

    @Query("SELECT w1 FROM Warehouse1 w1 " +
            "JOIN Goods g " +
            "ON w1.goodFromWHFirstId = g " +
            "WHERE g.priority = :priority")
    Iterable<Warehouse1> findGoodFromWHFirstByPriority(@Param("priority") Float priority);
}
