package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.aop.Timed;
import com.ddabadi.pos.domain.Barang;
import com.ddabadi.pos.domain.repository.BarangRepository;
import com.ddabadi.pos.service.BarangService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/7/17
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class BarangServiceImpl implements BarangService {

    private final Logger logger = Logger.getLogger(BarangService.class);

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public Barang save(Barang barang) {

        logger.info("Save");
        Barang barangCheck = this.getById(barang.getId());
        if(barangCheck == null){
            return barangRepository.save(barang);
        }   else{
            return this.update(barang);
        }
    }

    @Override
    public Barang update(Barang barang) {

        logger.info("Update");
        Barang barangUpdate = barangRepository.findOne(barang.getId());
        barangUpdate.setNama(barang.getNama());

        return barangRepository.save(barangUpdate);
    }



    @Override
    public Page<Barang> getBarang(PageRequest page){
        return barangRepository.findBarangs(page);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Barang getById(Long id) {
        return barangRepository.findOne(id);
    }
}
