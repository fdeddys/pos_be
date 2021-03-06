package com.ddabadi.pos.rest;

import com.ddabadi.pos.aop.Timed;
import com.ddabadi.pos.domain.Barang;
import com.ddabadi.pos.service.impl.BarangServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/7/17
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */

//@CrossOrigin

@RestController
@RequestMapping(value = "api/barang")
public class BarangController {

    private Logger logger = Logger.getLogger(BarangController.class);
    @Autowired private BarangServiceImpl barangService;

    @Timed
    @RequestMapping(method = RequestMethod.GET,
                    value = "/{hal}/{jumlah}")
    public Page<Barang> getBarangPage(@PathVariable int hal,
                                      @PathVariable int jumlah) {
        PageRequest pageRequest = new PageRequest(hal -1 ,jumlah, Sort.Direction.ASC,"id");
        return this.barangService.getAll(pageRequest);
    }

    @Timed
    @RequestMapping(method = RequestMethod.GET,
                    value = "{id}")
    public Barang getBarangById(@PathVariable Long id) {
        return this.barangService.getById(id);
    }


    @RequestMapping(method = RequestMethod.POST,
                    consumes = "application/json")
    public Barang saveBarang(@RequestBody Barang barang){
        logger.info("save " + barang);
        return barangService.save(barang);
    }




}
