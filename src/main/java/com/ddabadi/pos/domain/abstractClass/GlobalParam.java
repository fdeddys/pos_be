package com.ddabadi.pos.domain.abstractClass;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "abs_global_parameter") //, indexes = @Index (name = "ix_nama", columnList = "nama"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="global_type")
public abstract class GlobalParam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
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
