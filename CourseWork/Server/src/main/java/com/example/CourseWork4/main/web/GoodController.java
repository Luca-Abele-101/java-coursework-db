package com.example.CourseWork4.main.web;

import com.example.CourseWork4.main.dto.GoodsDto;
import com.example.CourseWork4.main.entities.Goods;
import com.example.CourseWork4.main.exception.GoodNotFoundException;
import com.example.CourseWork4.main.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodController
{
    private GoodService goodsService;

    @Autowired
    public void setGoodService(GoodService goodsService)
    {
        this.goodsService = goodsService;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Goods> add(@RequestBody GoodsDto goodsDto)
    {
        try
        {
            Goods good = goodsService.add(goodsDto);
            return new ResponseEntity<>(good, HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Goods> findById(@PathVariable("id") Integer id)
    {
        try
        {
            return new ResponseEntity<>(goodsService.findById(id), HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<Goods> findByName(@PathVariable("name") String name)
    {
        try
        {
            return new ResponseEntity<>(goodsService.findByName(name), HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-count/{priority}")
    public ResponseEntity<List<Goods>> findByPriority(@PathVariable("priority") Float priority)
    {
        try
        {
            List<Goods> goods = goodsService.findByPriority(priority);
            return new ResponseEntity<>(goods, HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-all")
    public ResponseEntity<List<Goods>> findAll()
    {
        try
        {
            List<Goods> goods = goodsService.findAll();
            return new ResponseEntity<>(goods, HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Goods> deleteGoodByName(@PathVariable("name") String name)
    {
        try
        {
            goodsService.deleteGoodByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
