package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.abstractClass.Person;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "m_supplier")
public class Supplier extends Person implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", unique = true, nullable = false)
//    private Long id;

    // is need PO
    @Column
    private  byte isPO=0;

    @Column
    private String email;

    @Column(length = 50)
    private String bankName;

    @Column(length = 25)
    private String accountNo;

    @Column(length = 50)
    private String accountName;

    @Column(length = 250)
    private String note;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte getPO() {
        return isPO;
    }

    public void setPO(byte PO) {
        isPO = PO;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
