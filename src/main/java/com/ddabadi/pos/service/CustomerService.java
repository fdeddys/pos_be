package com.ddabadi.pos.service;

import com.ddabadi.pos.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {

    public Customer save(Customer customer );
    public Customer update(Customer  customer);
    public Page<Customer > getAll(PageRequest page);
    public Customer getById(Long id);
}
