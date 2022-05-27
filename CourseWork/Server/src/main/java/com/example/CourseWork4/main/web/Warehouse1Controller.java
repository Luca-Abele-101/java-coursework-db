package com.example.CourseWork4.main.web;

import com.example.CourseWork4.main.entities.Warehouse1;
import com.example.CourseWork4.main.exception.Warehouse1NotFoundException;
import com.example.CourseWork4.main.service.Warehouse1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/warehouse1")
public class Warehouse1Controller
{
    private Warehouse1Service warehouse1Service;

    @Autowired
    public void setWarehouse1Service(Warehouse1Service warehouse1Service)
    {
        this.warehouse1Service = warehouse1Service;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Warehouse1> findById(@PathVariable("id") Integer id)
    {
        try
        {
            return new ResponseEntity<>(warehouse1Service.findById(id), HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-id/{goodId}")
    public ResponseEntity<Warehouse1> findByGoodID(@PathVariable("goodId") Integer goodId)
    {
        try
        {
            return new ResponseEntity<>(warehouse1Service.findById(goodId), HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-count/{goodCount}")
    public ResponseEntity<List<Warehouse1>> findByGoodCount(@PathVariable("goodCount") Integer goodCount)
    {
        try
        {
            List<Warehouse1> warehouse1 = warehouse1Service.findByGoodCount(goodCount);
            return new ResponseEntity<>(warehouse1, HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-all")
    public ResponseEntity<List<Warehouse1>> findAll()
    {
        try
        {
            List<Warehouse1> warehouse1 = warehouse1Service.findAll();
            return new ResponseEntity<>(warehouse1, HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-good-from-wh1-by-name/{name}")
    public ResponseEntity<List<Warehouse1>> findGoodFromWHFirstByName(@PathVariable("name") String name)
    {
        try
        {
            List<Warehouse1> warehouse1 = warehouse1Service.findGoodFromWHFirstByName(name);
            return new ResponseEntity<>(warehouse1, HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-good-from-wh1-by-priority/{priority}")
    public ResponseEntity<List<Warehouse1>> findGoodFromWHFirstByPriority(@PathVariable("priority") Float priority)
    {
        try
        {
            List<Warehouse1> warehouse1 = warehouse1Service.findGoodFromWHFirstByPriority(priority);
            return new ResponseEntity<>(warehouse1, HttpStatus.OK);
        }
        catch (Warehouse1NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

}
