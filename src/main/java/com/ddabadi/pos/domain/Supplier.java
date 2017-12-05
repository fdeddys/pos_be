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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    // is need PO
    private  byte isPO=0;

    public byte getPO() {
        return isPO;
    }

    public void setPO(byte PO) {
        isPO = PO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
