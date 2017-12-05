package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Customer;
import com.ddabadi.pos.domain.repository.CustomerRepository;
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
 * Date: 11/26/17
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CustomerServiceImpl implements GenericService<Customer> {

    private final Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer save(Customer customer) {
        logger.info("Save");
        Customer custCheck = this.getById(customer.getId());
        if(custCheck == null){
            return repository.save(customer);
        }   else{
            return this.update(customer);
        }
    }

    @Override
    public Customer update(Customer customer) {
        logger.info("Update");
        Customer customerUpdate = repository.findOne(customer.getId());
        customerUpdate.setNama(customer.getNama());
        customerUpdate.setLastUpdate(new Date());
        return repository.save(customerUpdate);
    }

    @Override
    public Page<Customer> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Customer getById(Long id) {
        return repository.findOne(id);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
