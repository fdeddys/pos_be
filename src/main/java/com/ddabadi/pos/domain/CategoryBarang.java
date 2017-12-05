package com.ddabadi.pos.domain;


import com.ddabadi.pos.domain.base.LoggedEntity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "m_category_barang",indexes =
        { @Index(columnList = "keterangan", name = "ix_keterangan")
        } )
public class CategoryBarang extends LoggedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "keterangan", length = 100)
    private String keterangan;


    @PrePersist
    private void prePersist(){
        if(this.getLastUpdate()==null)
            this.setLastUpdate(new Date());
    }

//    @Column(name = "last_update")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    protected Date lastUpdate= new Date();
//
//    public Date getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(Date lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }

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
