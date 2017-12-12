package com.ddabadi.pos.domain;

import com.ddabadi.pos.enumType.EnStatus;
import com.ddabadi.pos.domain.base.LoggedEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/5/17
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "m_barang",
       indexes = {
            @Index(columnList="id", name="ix_id"),
            @Index(columnList = "nama", name="ix_nama_barang")
        })
public class Barang extends LoggedEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column
    private EnStatus enStatus;

    @ManyToMany(mappedBy = "barangs")
    private Set<CategoryBarang> categoryBarangs = new HashSet<CategoryBarang>();

    @OneToOne
    @JoinColumn(name = "satuan")
    private Satuan satuan;

    @OneToMany(mappedBy = "barang")
    private Set<Stock> stocks = new HashSet<Stock>();

    @Column
    private Long minStock;

    @Column
    private Long maxStock;

    @PrePersist
    private void prePersist(){
        if(this.getEnStatus()==null){
            this.setEnStatus(EnStatus.ACTIVE);
        }
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Long getMinStock() {
        return minStock;
    }

    public void setMinStock(Long minStock) {
        this.minStock = minStock;
    }

    public Long getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Long maxStock) {
        this.maxStock = maxStock;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public Set<CategoryBarang> getCategoryBarangs() {
        return categoryBarangs;
    }

    public void setCategoryBarangs(Set<CategoryBarang> categoryBarangs) {
        this.categoryBarangs = categoryBarangs;
    }

    public EnStatus getEnStatus() {
        return enStatus;
    }

    public void setEnStatus(EnStatus enStatus) {
        this.enStatus = enStatus;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
