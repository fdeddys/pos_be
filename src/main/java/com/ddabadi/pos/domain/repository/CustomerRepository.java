package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
