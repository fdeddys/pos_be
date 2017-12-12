package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/10/17
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
