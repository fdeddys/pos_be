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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @Autowired private StockServiceImpl stockService;
    @Autowired private SalesServiceImpl salesService;
    @Autowired private BankServiceImpl bankService;

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
        barang.setSatuan(satuan);
        barang = barangService.save(barang);

        logger.info("barang add catg");
        Set<CategoryBarang> categoryBarangs = new HashSet<CategoryBarang>();
        categoryBarangs.add(categoryBarang);
        barang.setCategoryBarangs(categoryBarangs);
        barang = barangService.save(barang);

        logger.info("Catg add barang");
        Set<Barang> barangs = new HashSet<Barang>();
        barangs.add(barang);
        categoryBarang.setBarangs(barangs);
        categoryBarangService.save(categoryBarang);


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
        gudang = gudangService.save(gudang);

        Stock stock = new Stock();
        stock.setBarang(barang);
        stock.setGudang(gudang);
        stock.setQty(1L);
        stockService.save(stock);

        Sales sales = new Sales();
        sales.setKontakPerson("abc");
        sales.setNama("jojon");
        sales.setAlamat1("alamatt");
        sales.setNIK("123");
        sales.setNpwp("456");
        sales.setStatusKary(EnStatus.ACTIVE);
        sales.setTempatLahir("jkt");
        sales.setTglLahir(new Date());
        sales.setAlamat2("alamat 2");
        sales.setKota("kotak");
        sales = salesService.save(sales);
        System.out.println("nama awal " + sales.getNama());

        sales.setStatusKary(EnStatus.NONACTIVE);
        sales.setNama("budi");
        salesService.save(sales);
        System.out.println("nama akhir " + sales.getNama());

        Bank bank = new Bank();
        bank.setAccountNo("123");
        bank.setAddress("jalannn");
        bank.setBankStatus(EnStatus.ACTIVE);
        bank.setBranch("cabang mana");
        bank.setCity("jkt48");
        bank.setNama("bank abang ");
        bankService.save(bank) ;

        return "sukses";

    }

}
