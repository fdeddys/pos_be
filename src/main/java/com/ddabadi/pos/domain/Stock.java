package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.base.LoggedEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "m_stock")
public class Stock extends LoggedEntity implements Serializable {

    @Id
    @Column(name = "id_stock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="barang_id")
    private Barang barang;

    @ManyToOne
    @JoinColumn(name = "gudang_id")
    private Gudang gudang;

    @Column(name = "qty")
    private Long qty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Gudang getGudang() {
        return gudang;
    }

    public void setGudang(Gudang gudang) {
        this.gudang = gudang;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
}
