package com.example.CourseWork4.main.web;

import com.example.CourseWork4.main.entities.Warehouse2;
import com.example.CourseWork4.main.exception.Warehouse2NotFoundException;
import com.example.CourseWork4.main.service.Warehouse2Service;
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
@RequestMapping("/warehouse2")
public class Warehouse2Controller
{
    private Warehouse2Service warehouse2Service;

    @Autowired
    public void setWarehouse2Service(Warehouse2Service warehouse2Service)
    {
        this.warehouse2Service = warehouse2Service;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Warehouse2> findById(@PathVariable("id") Integer id)
    {
        try
        {
            return new ResponseEntity<>(warehouse2Service.findById(id), HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-id/{goodId}")
    public ResponseEntity<Warehouse2> findByGoodID(@PathVariable("goodId") Integer goodId)
    {
        try
        {
            return new ResponseEntity<>(warehouse2Service.findById(goodId), HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-count/{goodCount}")
    public ResponseEntity<List<Warehouse2>> findByGoodCount(@PathVariable("goodCount") Integer goodCount)
    {
        try
        {
            List<Warehouse2> warehouse2 = warehouse2Service.findByGoodCount(goodCount);
            return new ResponseEntity<>(warehouse2, HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-all")
    public ResponseEntity<List<Warehouse2>> findAll()
    {
        try
        {
            List<Warehouse2> warehouse2 = warehouse2Service.findAll();
            return new ResponseEntity<>(warehouse2, HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-good-from-wh2-by-name/{name}")
    public ResponseEntity<List<Warehouse2>> findGoodFromWHSecondByName(@PathVariable("name") String name)
    {
        try
        {
            List<Warehouse2> warehouse2 = warehouse2Service.findGoodFromWHSecondByName(name);
            return new ResponseEntity<>(warehouse2, HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-good-from-wh2-by-priority/{priority}")
    public ResponseEntity<List<Warehouse2>> findGoodFromWHSecondByPriority(@PathVariable("priority") Float priority)
    {
        try
        {
            List<Warehouse2> warehouse2 = warehouse2Service.findGoodFromWHSecondByPriority(priority);
            return new ResponseEntity<>(warehouse2, HttpStatus.OK);
        }
        catch (Warehouse2NotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };
}
