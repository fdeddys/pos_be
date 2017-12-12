package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.base.LoggedEntity;
import com.ddabadi.pos.enumType.EnStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "m_gudang", indexes = @Index(columnList = "nama", name = "ix_nama_gudang"))
public class Gudang extends LoggedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String nama;

    @OneToMany(mappedBy = "gudang")
    private Set<Stock> stocks = new HashSet<Stock>();

    @Column
    private EnStatus enStatus;

    @Column
    private String alamat1;

    @Column
    private String alamat2;

    @Column(length = 100)
    private String kota;

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public EnStatus getEnStatus() {
        return enStatus;
    }

    public void setEnStatus(EnStatus enStatus) {
        this.enStatus = enStatus;
    }

    public String getAlamat1() {
        return alamat1;
    }

    public void setAlamat1(String alamat1) {
        this.alamat1 = alamat1;
    }

    public String getAlamat2() {
        return alamat2;
    }

    public void setAlamat2(String alamat2) {
        this.alamat2 = alamat2;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
