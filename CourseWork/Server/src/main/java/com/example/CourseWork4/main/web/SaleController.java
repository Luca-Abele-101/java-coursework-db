package com.example.CourseWork4.main.web;

import com.example.CourseWork4.main.dto.GoodsDto;
import com.example.CourseWork4.main.dto.SalesDto;
import com.example.CourseWork4.main.entities.Goods;
import com.example.CourseWork4.main.entities.Sales;
import com.example.CourseWork4.main.exception.GoodNotFoundException;
import com.example.CourseWork4.main.exception.SaleNotFoundException;
import com.example.CourseWork4.main.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sales")
public class SaleController
{
    @Autowired
    private SaleService salesService;

    @Autowired
    public void setSaleService(SaleService salesService)
    {
        this.salesService = salesService;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Sales> addSales(@RequestBody SalesDto salesDto)
    {
        try
        {
            Sales sale = salesService.add(salesDto);
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }
        catch (GoodNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Sales> findById(@PathVariable("id") Integer id)
    {
        try
        {
            return new ResponseEntity<>(salesService.findById(id), HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-id/{goodId}")
    public ResponseEntity<Sales> findByGoodID(@PathVariable("goodId") Integer goodId)
    {
        try
        {
            return new ResponseEntity<>(salesService.findByGoodID(goodId), HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-good-count/{goodCount}")
    public ResponseEntity<List<Sales>> findByGoodCount(@PathVariable("goodCount") Integer goodCount)
    {
        try
        {
            List<Sales> sales = salesService.findByGoodCount(goodCount);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-by-create-data/{createData}")
    public ResponseEntity<List<Sales>> findByCreateData(@PathVariable("createData") Timestamp createData)
    {
        try
        {
            List<Sales> sales = salesService.findByCreateData(createData);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-all")
    public ResponseEntity<List<Sales>> findAll()
    {
        try
        {
            List<Sales> sales = salesService.findAll();
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-sale-by-name/{name}")
    public ResponseEntity<List<Sales>> findSaleByName(@PathVariable("name") String name)
    {
        try
        {
            List<Sales> sales = salesService.findSaleByName(name);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @GetMapping("/find-sale-by-priority/{priority}")
    public ResponseEntity<List<Sales>> findSaleByPriority(@PathVariable("priority") Float priority)
    {
        try
        {
            List<Sales> sales = salesService.findSaleByPriority(priority);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    };

    @PutMapping("/update-sale/{id}")
    public void updateClient(@PathVariable("id") Integer id, @RequestBody Map<String, Integer> js)
    {
        Integer newGoodCount = js.get("newGoodCount");
        salesService.updateSale(id, newGoodCount);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sales> deleteSaleById(@PathVariable("id") Integer id)
    {
        try
        {
            salesService.deleteSaleById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (SaleNotFoundException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
