package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.CategoryBarang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryBarangRepository extends CrudRepository<CategoryBarang, Long > {

    Page<CategoryBarang> findAll(Pageable pageable);
}
