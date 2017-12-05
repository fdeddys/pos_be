package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Satuan;
import com.ddabadi.pos.domain.repository.SatuanRepository;
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
 * Date: 12/5/17
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class SatuanServiceImpl implements GenericService<Satuan> {

    @Autowired private SatuanRepository repository;
    private final Logger logger = Logger.getLogger(SatuanServiceImpl.class);

    @Override
    public Satuan save(Satuan satuan) {
        return repository.save(satuan);
    }

    @Override
    public Satuan update(Satuan satuan) {
        Satuan satuanUpd = repository.findOne(satuan.getId());
        satuanUpd.setNama(satuan.getNama());
        satuanUpd.setLastUpdate(new Date());
        return repository.save(satuanUpd);
    }

    @Override
    public Page<Satuan> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Satuan getById(Long id) {
        return repository.findOne(id);
    }
}
