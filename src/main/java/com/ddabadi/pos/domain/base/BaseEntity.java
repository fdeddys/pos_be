package com.ddabadi.pos.domain.base;

import com.ddabadi.pos.config.BarangStatus;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/26/17
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class BaseEntity {

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date lastUpdate= new Date();

    @PrePersist
    private void prePersist(){
//        if(this.getLastUpdate()==null)
//            this.setLastUpdate(new Date());
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
