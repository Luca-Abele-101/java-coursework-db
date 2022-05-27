package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.dto.GoodsDto;
import com.example.CourseWork4.main.entities.Goods;
import com.example.CourseWork4.main.exception.GoodNotFoundException;
import com.example.CourseWork4.main.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService
{
    @Autowired
    private GoodRepository goodsRepository;


    @Override
    public Goods add(GoodsDto goodsDto)
    {
        String name = goodsDto.getName();
        Float priority = goodsDto.getPriority();
        Goods good = new Goods(name, priority);
        goodsRepository.save(good);
        return good;
    }

    @Override
    public Goods findById(Integer id)
    {
        Optional<Goods> res = goodsRepository.findById(id);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new GoodNotFoundException("Book not found");
        }
    }

    @Override
    public Goods findByName(String name)
    {
        Optional<Goods> res = goodsRepository.findByName(name);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new GoodNotFoundException("Book not found");
        }
    }

    @Override
    public List<Goods> findByPriority(Float priority)
    {
        return (List<Goods>) goodsRepository.findByPriority(priority);
    }

    @Override
    public List<Goods> findAll()
    {
        return (List<Goods>) goodsRepository.findAll();
    }

    @Override
    public void deleteGoodByName(String name)
    {
        goodsRepository.deleteGoodByName(name);
    }
}
