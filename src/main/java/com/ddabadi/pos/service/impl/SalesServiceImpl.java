package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Sales;
import com.ddabadi.pos.domain.repository.SalesRepository;
import com.ddabadi.pos.service.GenericService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class SalesServiceImpl implements GenericService<Sales> {

    @Autowired
    private SalesRepository repository;
    private final Logger logger = Logger.getLogger(SalesServiceImpl.class);

    @Override
    public Sales save(Sales sales) {
        return repository.save(sales);
    }

    @Override
    public Sales update(Sales sales) {
        return this.save(sales);
    }

    @Override
    public Page<Sales> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Sales getById(Long id) {
        return repository.findOne(id);
    }

}
