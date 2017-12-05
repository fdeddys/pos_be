package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.Gudang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface GudangRepository extends JpaRepository<Gudang,Long> {

    List<Gudang> findByNamaOrderByNama(String nama);
}
