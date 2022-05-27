package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.entities.Warehouse2;
import com.example.CourseWork4.main.exception.SaleNotFoundException;
import com.example.CourseWork4.main.repository.Warehouse2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Warehouse2ServiceImpl implements Warehouse2Service
{
    @Autowired
    private Warehouse2Repository warehouse2Repository;

    @Override
    public Warehouse2 findById(Integer id)
    {
        Optional<Warehouse2> res = warehouse2Repository.findById(id);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Warehouse2Good not found");
        }
    }

    @Override
    public Warehouse2 findByGoodID(Integer goodId)
    {
        Optional<Warehouse2> res = warehouse2Repository.findByGoodID(goodId);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Warehouse2Good not found");
        }
    }

    @Override
    public List<Warehouse2> findByGoodCount(Integer goodCount)
    {
        return (List<Warehouse2>) warehouse2Repository.findByGoodCount(goodCount);
    }

    @Override
    public List<Warehouse2> findAll()
    {
        return (List<Warehouse2>) warehouse2Repository.findAll();
    }

    @Override
    public List<Warehouse2> findGoodFromWHSecondByName(String name)
    {
        return (List<Warehouse2>) warehouse2Repository.findGoodFromWHSecondByName(name);
    }

    @Override
    public List<Warehouse2> findGoodFromWHSecondByPriority(Float priority)
    {
        return (List<Warehouse2>) warehouse2Repository.findGoodFromWHSecondByPriority(priority);
    }
}
