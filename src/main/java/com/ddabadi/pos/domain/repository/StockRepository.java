package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
