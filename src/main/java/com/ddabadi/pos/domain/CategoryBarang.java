package com.ddabadi.pos.domain;


import com.ddabadi.pos.domain.base.BaseEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "m_category_barang",indexes =
        { @Index(columnList = "keterangan", name = "ix_keterangan")
        } )
public class CategoryBarang  extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "keterangan", length = 100)
    private String keterangan;

//    @OneToMany(mappedBy = "categoryBarang",cascade = CascadeType.ALL)
//    //, targetEntity = Barang.class, fetch = FetchType.LAZY)
//    //@JoinColumn(name ="id_catg")
//    private List<Barang> barangList;

    @PrePersist
    private void prePersist(){
        if(this.getLastUpdate()==null)
            this.setLastUpdate(new Date());
    }

    public Long getId() {
        return id;
    }

//    public List<Barang> getBarangList() {
//        return barangList;
//    }
//
//    public void setBarangList(List<Barang> barangList) {
//        this.barangList = barangList;
//    }

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
