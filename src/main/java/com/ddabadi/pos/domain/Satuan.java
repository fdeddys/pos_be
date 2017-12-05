package com.ddabadi.pos.domain;

import com.ddabadi.pos.domain.abstractClass.GlobalParam;
import com.ddabadi.pos.domain.base.LoggedEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@DiscriminatorValue(value = "satuan")
public class Satuan extends GlobalParam {

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date lastUpdate= new Date();

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
