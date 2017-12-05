package com.ddabadi.pos.rest;

import com.ddabadi.pos.aop.Timed;
import com.ddabadi.pos.domain.*;
import com.ddabadi.pos.enumType.EnStatus;
import com.ddabadi.pos.service.impl.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "api")
public class TestController {

    private Logger logger= Logger.getLogger(TestController.class) ;

    @Autowired private BarangServiceImpl barangService;
    @Autowired private CategoryBarangServiceImpl categoryBarangService;
    @Autowired private CustomerServiceImpl customerService;
    @Autowired private SatuanServiceImpl satuanService;
    @Autowired private GudangServiceImpl gudangService;

    @RequestMapping(method = RequestMethod.GET, value = "tesData")
    @Timed
    @Transactional(value = Transactional.TxType.REQUIRED)
    public String getGen() {

        Satuan satuan = new Satuan();
        satuan.setNama("pieces");
        satuanService.save(satuan);

        logger.info("create new Catg");
        CategoryBarang categoryBarang = new CategoryBarang();
        categoryBarang.setId(0L);
        categoryBarang.setKeterangan("atk");
        categoryBarang= categoryBarangService.save(categoryBarang);

        logger.info("create new barang");
        Barang barang = new Barang();
        barang.setNama("Pena");
        barang.setId(0L);
        barang.setCategoryBarang(categoryBarang);
        barang.setSatuan(satuan);
        barangService.save(barang);

        logger.info("create new Customer");
        Customer customer= new Customer();
        customer.setId(0L);
        customer.setNama("tes cstomr");
        customer.setCanCredit((byte) 1);
        customer.setTop(30);
        customer.setAlamat1("alamat 1");
        customer.setAlamat2("alamat 2");
        customer.setKontakPerson("nama kontak");
        customer.setKota("kota") ;
        customerService.save(customer);

        Gudang gudang = new Gudang();
        gudang.setNama("gudang 1");
        gudang.setAlamat1("alamat 1");
        gudang.setEnStatus(EnStatus.ACTIVE);
        gudangService.save(gudang);


        return "sukses";

    }

}
