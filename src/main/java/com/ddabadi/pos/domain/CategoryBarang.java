package com.ddabadi.pos.domain;


import com.ddabadi.pos.domain.base.LoggedEntity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "m_categorybarang",
       indexes ={ @Index(columnList = "keterangan", name = "ix_keterangan")}
)
public class CategoryBarang extends LoggedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "keterangan", length = 100)
    private String keterangan;

    @ManyToMany
    @JoinTable(
            name = "m_barang_categorybarang",
            joinColumns = @JoinColumn(name = "id_categorybarang"),
            inverseJoinColumns = @JoinColumn(name = "id_barang")
    )
    private Set<Barang> barangs = new HashSet<Barang>();

    @PrePersist
    private void prePersist(){
        if(this.getLastUpdate()==null)
            this.setLastUpdate(new Date());
    }

    public Set<Barang> getBarangs() {
        return barangs;
    }

    public void setBarangs(Set<Barang> barangs) {
        this.barangs = barangs;
    }

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
