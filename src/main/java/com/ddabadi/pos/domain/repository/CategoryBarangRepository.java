package com.ddabadi.pos.domain.repository;

import com.ddabadi.pos.domain.CategoryBarang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryBarangRepository extends JpaRepository<CategoryBarang, Long > {

    @Override
    Page<CategoryBarang> findAll(Pageable pageable);
}
