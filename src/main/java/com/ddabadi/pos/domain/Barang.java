package com.ddabadi.pos.domain;

import com.ddabadi.pos.enumType.EnStatus;
import com.ddabadi.pos.domain.base.LoggedEntity;

import javax.persistence.*;
import java.io.Serializable;

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
            @Index(columnList = "nama", name="ix_nama")
        })
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Barang extends LoggedEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column
    private EnStatus enStatus;

    @ManyToOne
    @JoinColumn(name = "id_category_barang")
    private CategoryBarang categoryBarang;

    @OneToOne
    @JoinColumn(name = "satuan")
    private Satuan satuan;

    @PrePersist
    private void prePersist(){
        if(this.getEnStatus()==null){
            this.setEnStatus(EnStatus.ACTIVE);
        }
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public CategoryBarang getCategoryBarang() {
        return categoryBarang;
    }

    public void setCategoryBarang(CategoryBarang categoryBarang) {
        this.categoryBarang = categoryBarang;
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
