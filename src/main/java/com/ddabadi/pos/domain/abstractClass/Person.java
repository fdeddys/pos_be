package com.ddabadi.pos.domain.abstractClass;

import com.ddabadi.pos.domain.base.LoggedEntity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table( name = "abs_person",
        indexes = { @Index(columnList = "nama", name = "ix_nama")}
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends LoggedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column(length = 250)
    private String alamat1;

    @Column(length = 250)
    private String alamat2;

    @Column(length = 30)
    private String telp1;

    @Column(length = 30)
    private String telp2;

    @Column(length = 100)
    private String kota;

    @Column(length = 100)
    private String kontakPerson;

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

    public String getTelp1() {
        return telp1;
    }

    public void setTelp1(String telp1) {
        this.telp1 = telp1;
    }

    public String getTelp2() {
        return telp2;
    }

    public void setTelp2(String telp2) {
        this.telp2 = telp2;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKontakPerson() {
        return kontakPerson;
    }

    public void setKontakPerson(String kontakPerson) {
        this.kontakPerson = kontakPerson;
    }
}
