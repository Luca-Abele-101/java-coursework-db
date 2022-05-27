package com.example.CourseWork4.main.repository;

import com.example.CourseWork4.main.entities.Goods;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface GoodRepository extends CrudRepository<Goods, Integer>
{
    Optional<Goods> findById(Integer id);
    Optional<Goods> findByName(String name);
    Iterable<Goods> findByPriority(Float priority);

    Iterable<Goods> findAll();

    @Transactional
    void deleteGoodByName(String name);
}
