package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.base.LoggedEntity;
import com.ddabadi.pos.enumType.EnStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/10/17
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "m_bank",
       indexes = {@Index(name = "ix_nama_bank", columnList = "nama")}
)
public class Bank extends LoggedEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nama;

    @Column(length = 25)
    private String accountNo;

    @Column(length = 100)
    private String branch;

    @Column(length = 250)
    private String address;

    @Column(length = 50)
    private String city;

    @Column
    private EnStatus bankStatus;

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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EnStatus getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(EnStatus bankStatus) {
        this.bankStatus = bankStatus;
    }
}
