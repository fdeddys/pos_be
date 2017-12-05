package com.ddabadi.pos.service.impl;

import com.ddabadi.pos.domain.Gudang;
import com.ddabadi.pos.domain.repository.GudangRepository;
import com.ddabadi.pos.service.GenericService;
import com.ddabadi.pos.service.GudangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class GudangServiceImpl implements GenericService<Gudang>, GudangService {

    @Autowired private GudangRepository repository;

    @Override
    public Gudang save(Gudang gudang) {
        return repository.save(gudang);
    }

    @Override
    public Gudang update(Gudang gudang) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<Gudang> getAll(PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Gudang getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Gudang> getByNama(String nama) {
        return repository.findByNamaOrderByNama("%"+nama+"%");
    }

}
