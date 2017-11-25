package com.ddabadi.pos.service;


import com.ddabadi.pos.domain.CategoryBarang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/20/17
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryBarangService {

    public CategoryBarang save(CategoryBarang  categoryBarang );
    public CategoryBarang update(CategoryBarang  categoryBarang);
    public Page<CategoryBarang > getAll(PageRequest page);
    public CategoryBarang getById(Long id);
}
