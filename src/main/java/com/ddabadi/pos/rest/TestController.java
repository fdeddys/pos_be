package com.ddabadi.pos.rest;

import com.ddabadi.pos.aop.Timed;
import com.ddabadi.pos.domain.Barang;
import com.ddabadi.pos.domain.CategoryBarang;
import com.ddabadi.pos.domain.Customer;
import com.ddabadi.pos.service.BarangService;
import com.ddabadi.pos.service.CategoryBarangService;
import com.ddabadi.pos.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired private BarangService barangService;
    @Autowired private CategoryBarangService categoryBarangService;
    @Autowired private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "tesData")
    @Timed
    @Transactional(value = Transactional.TxType.REQUIRED)
    public String getGen() {

        logger.info("create new Catg");
//        CategoryBarang categoryBarang = new CategoryBarang();
//        categoryBarang.setId(0L);
//        categoryBarang.setKeterangan("atk");
//        categoryBarang= categoryBarangService.save(categoryBarang);
//
        CategoryBarang categoryBarang = categoryBarangService.getById(1L);

        logger.info("create new barang");
        Barang barang = new Barang();
        barang.setNama("Pena");
        barang.setId(0L);
        barang.setCategoryBarang(categoryBarang);
        barangService.save(barang);

//        Barang barang2 = new Barang();
//        barang2.setNama("Pensil");
//        barang2.setId(0L);
//        barang2.setCategoryBarang(categoryBarang);

        //categoryBarang.setBarangList(barangs);




//        CategoryBarang categoryBarang2 = new CategoryBarang();
//        categoryBarang2.setId(0L);
//        categoryBarang2.setKeterangan("Komputer");
//        categoryBarangService.save(categoryBarang2);
//
//        Barang barang2 = new Barang();
//        barang2.setId(0L);
//        barang2.setNama("Mouse");
//        barang2.setCategoryBarang(categoryBarang2);
//        barangService.save(barang2);


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

        return "sukses";

    }

}
