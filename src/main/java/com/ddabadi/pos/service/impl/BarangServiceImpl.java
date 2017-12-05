package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Barang;
import com.ddabadi.pos.domain.repository.BarangRepository;
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
 * Date: 11/7/17
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class BarangServiceImpl implements GenericService<Barang> {

    private final Logger logger = Logger.getLogger(BarangServiceImpl.class);

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public Barang save(Barang barang) {

        logger.info("BarangServiceImpl:begin save");
        Barang barangCheck = this.getById(barang.getId());
        if(barangCheck == null){
            logger.info("BarangServiceImpl:Save"+ barang);
            return barangRepository.save(barang);
        }   else{
            logger.info("BarangServiceImpl:update");
            return this.update(barang);
        }
    }

    @Override
    public Barang update(Barang barang) {

        logger.info("Update");
        Barang barangUpdate = barangRepository.findOne(barang.getId());
        barangUpdate.setNama(barang.getNama());
        barangUpdate.setLastUpdate(new Date());
        return barangRepository.save(barangUpdate);
    }

    @Override
    public Page<Barang> getAll(PageRequest page){
        return barangRepository.findBarangs(page);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Barang getById(Long id) {
        return barangRepository.findOne(id);
    }
}
