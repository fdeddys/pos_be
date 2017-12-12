package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {
}
