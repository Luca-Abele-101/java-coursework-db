package com.example.CourseWork4.main.service;

import com.example.CourseWork4.main.dto.SalesDto;
import com.example.CourseWork4.main.entities.Goods;
import com.example.CourseWork4.main.entities.Sales;
import com.example.CourseWork4.main.exception.SaleNotFoundException;
import com.example.CourseWork4.main.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements  SaleService
{
    @Autowired
    private SaleRepository salesRepository;

    @Autowired
    private  GoodService goodService;

    @Override
    public Sales add(SalesDto salesDto)
    {
        Integer goodID = salesDto.getGoodID();
        Integer goodCount = salesDto.getGoodCount();
        Timestamp createData = salesDto.getCreateData();
        Goods goodId = goodService.findById(goodID);

        Sales sale = new Sales(goodID, goodCount, createData, goodId);
        salesRepository.save(sale);
        return sale;
    }

    @Override
    public Sales addSales(Sales sales)
    {
        return salesRepository.save(sales);
    }

    @Override
    public Sales findById(Integer id)
    {
        Optional<Sales> res = salesRepository.findById(id);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Sale not found");
        }
    }

    @Override
    public Sales findByGoodID(Integer goodId)
    {
        Optional<Sales> res = salesRepository.findById(goodId);
        if(res.isPresent())
        {
            return res.get();
        }
        else
        {
            throw new SaleNotFoundException("Sale not found");
        }
    }

    @Override
    public List<Sales> findByGoodCount(Integer goodCount)
    {
        return (List<Sales>) salesRepository.findByGoodCount(goodCount);
    }

    @Override
    public List<Sales> findByCreateData(Timestamp createData)
    {
        return (List<Sales>) salesRepository.findByCreateData(createData);
    }

    @Override
    public List<Sales> findAll()
    {
        return (List<Sales>) salesRepository.findAll();
    }

    @Override
    public List<Sales> findSaleByName(String name)
    {
        return (List<Sales>) salesRepository.findSaleByName(name);
    }

    @Override
    public List<Sales> findSaleByPriority(Float priority)
    {
        return (List<Sales>) salesRepository.findSaleByPriority(priority);
    }

    @Override
    public void updateSale(Integer id, Integer newGoodCount)
    {
        salesRepository.updateSale(id, newGoodCount);
    }

    @Override
    public void deleteSaleById(Integer id)
    {
        salesRepository.deleteSaleById(id);
    }
}
