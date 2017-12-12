package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Bank;
import com.ddabadi.pos.domain.repository.BankRepository;
import com.ddabadi.pos.service.GenericService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/10/17
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BankServiceImpl implements GenericService<Bank> {

    @Autowired private BankRepository repository;
    private Logger logger = Logger.getLogger(BankServiceImpl.class);

    @Override
    public Bank save(Bank bank) {
        return repository.save(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return this.save(bank);
    }

    @Override
    public Page<Bank> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Bank getById(Long id) {
        return repository.findOne(id);
    }
}
