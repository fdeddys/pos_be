package com.ddabadi.pos.service;

import com.ddabadi.pos.domain.Gudang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/5/17
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GudangService {
    List<Gudang> getByNama(String nama);
}
