package com.ddabadi.pos.domain;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_category_barang")
public class CategoryBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @CreatedBy
    private Long id;

    @Column(name = "keterangan", length = 100)
    private String keterangan;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
