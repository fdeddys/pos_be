package com.ddabadi.pos.service;

import com.ddabadi.pos.aop.Timed;
import com.ddabadi.pos.domain.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/7/17
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */

public interface BarangService {


    public Barang save(Barang barang);
    public Barang update(Barang barang);
    public Page<Barang> getBarang(PageRequest page);
    public Barang getById(Long id);


}
