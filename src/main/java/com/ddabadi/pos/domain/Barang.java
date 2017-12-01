package com.ddabadi.pos.domain;

import ch.qos.logback.classic.db.names.ColumnName;
import com.ddabadi.pos.config.BarangStatus;
import com.ddabadi.pos.domain.base.BaseEntity;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
public class Barang extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column
    private BarangStatus barangStatus;

    @ManyToOne
    //(optional = true, fetch = FetchType.EAGER)
    //, cascade = CascadeType.)
    //, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_categoryBarang", updatable = true, insertable = false)
    //, nullable = true)
    private CategoryBarang categoryBarang;

    @PrePersist
    private void prePersist(){
        if(this.getBarangStatus()==null){
            this.setBarangStatus(BarangStatus.ACTIVE);
        }
    }

    public CategoryBarang getCategoryBarang() {
        return categoryBarang;
    }

    public void setCategoryBarang(CategoryBarang categoryBarang) {
        this.categoryBarang = categoryBarang;
    }

    public BarangStatus getBarangStatus() {
        return barangStatus;
    }

    public void setBarangStatus(BarangStatus barangStatus) {
        this.barangStatus = barangStatus;
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
