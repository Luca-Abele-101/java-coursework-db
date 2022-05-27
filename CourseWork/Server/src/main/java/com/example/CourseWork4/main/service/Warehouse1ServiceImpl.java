package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.entities.Warehouse1;
import com.example.CourseWork4.main.exception.SaleNotFoundException;
import com.example.CourseWork4.main.repository.Warehouse1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Warehouse1ServiceImpl implements Warehouse1Service
{
    @Autowired
    private Warehouse1Repository warehouse1Repository;

    @Override
    public Warehouse1 findById(Integer id)
    {
        Optional<Warehouse1> res = warehouse1Repository.findById(id);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Warehouse1Good not found");
        }
    }

    @Override
    public Warehouse1 findByGoodID(Integer goodId)
    {
        Optional<Warehouse1> res = warehouse1Repository.findByGoodID(goodId);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Warehouse1Good not found");
        }
    }

    @Override
    public List<Warehouse1> findByGoodCount(Integer goodCount)
    {
        return (List<Warehouse1>) warehouse1Repository.findByGoodCount(goodCount);
    }

    @Override
    public List<Warehouse1> findAll()
    {
        return (List<Warehouse1>) warehouse1Repository.findAll();
    }

    @Override
    public List<Warehouse1> findGoodFromWHFirstByName(String name)
    {
        return (List<Warehouse1>) warehouse1Repository.findGoodFromWHFirstByName(name);
    }

    @Override
    public List<Warehouse1> findGoodFromWHFirstByPriority(Float priority)
    {
        return (List<Warehouse1>) warehouse1Repository.findGoodFromWHFirstByPriority(priority);
    }
}
