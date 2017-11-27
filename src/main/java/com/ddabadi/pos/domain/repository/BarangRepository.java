package com.ddabadi.pos.domain.repository;


import com.ddabadi.pos.domain.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/5/17
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */

@CrossOrigin
//@RepositoryRestResource(collectionResourceRel = "impl", path = "impl")
public interface BarangRepository extends CrudRepository<Barang, Long> {

    List<Barang> findByNama(@Param("nama")String nama);

    //  /people/search/nameStartsWith
    //  /people/search/nameStartsWith?name=K&sort=name,desc
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page findByNamaStartsWith(@Param("nama") String name, Pageable p);

    @Query("select b from Barang b")
    Page<Barang> findBarangs(Pageable pageable);
}
