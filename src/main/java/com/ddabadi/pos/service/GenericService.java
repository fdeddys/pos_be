package com.ddabadi.pos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GenericService <Model> {
    public Model save(Model model);
    public Model update(Model model);
    public Page<Model> getAll(PageRequest page);
    public Model getById(Long id);
}
