package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.abstractClass.Person;
import com.ddabadi.pos.enumType.EnStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/8/17
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "m_sales")
public class Sales extends Person implements Serializable {

    @Column(length = 50)
    private String NIK;

    @Column
    @Temporal(TemporalType.DATE)
    private Date tglLahir;

    @Column(length = 50)
    private String tempatLahir;

    @Column
    private EnStatus statusKary;

    @Column(length = 30)
    private String npwp;

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public EnStatus getStatusKary() {
        return statusKary;
    }

    public void setStatusKary(EnStatus statusKary) {
        this.statusKary = statusKary;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }
}
