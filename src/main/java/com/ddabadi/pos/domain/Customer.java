package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.abstractClass.Person;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "m_customer")
public class Customer extends Person implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_customer", unique = true, nullable = false)
//    private Long id;

    private byte canCredit=0;

    // term of payment
    private long top=0;

    @Column(length = 50)
    private String npwp;

    @PrePersist
    private void prePersist(){
        if(this.getNpwp()==null){
            this.setNpwp("");
        }
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public long getTop() {
        return top;
    }

    public void setTop(long top) {
        this.top = top;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public byte getCanCredit() {
        return canCredit;
    }

    public void setCanCredit(byte canCredit) {
        this.canCredit = canCredit;
    }
}
