package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Stock;
import com.ddabadi.pos.domain.repository.StockRepository;
import com.ddabadi.pos.service.GenericService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class StockServiceImpl implements GenericService<Stock> {

    @Autowired
    private StockRepository repository;
    private final Logger logger = Logger.getLogger(StockServiceImpl.class);

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Stock update(Stock stock) {
        Stock stockUpd = repository.findOne(stock.getId());
        stockUpd.setGudang(stock.getGudang());
        stockUpd.setBarang(stock.getBarang());
        stockUpd.setQty(stock.getQty());
        stockUpd.setLastUpdate(new Date());
        return repository.save(stockUpd);
    }

    @Override
    public Page<Stock> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Stock getById(Long id) {
        return repository.findOne(id);
    }
}
