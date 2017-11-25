package com.ddabadi.pos.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/5/17
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class Barang {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nama;

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
}
