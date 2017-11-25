package com.ddabadi.pos.rest;


import com.ddabadi.pos.domain.CategoryBarang;
import com.ddabadi.pos.domain.repository.CategoryBarangRepository;
import com.ddabadi.pos.service.CategoryBarangService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
//@EnableAutoConfiguration
@RequestMapping(value = "api/categoryBarang",
                produces = "application/json")
public class CategoryBarangController {

    private Logger logger = Logger.getLogger(CategoryBarangController.class);

    @Autowired private CategoryBarangService service;

    @RequestMapping(value = "{page}/{size}",
                    method = RequestMethod.GET)
    public Page<CategoryBarang> getAll(@PathVariable int page,
                                       @PathVariable int size){
        Sort sort= new Sort(Sort.Direction.ASC,"id").and(new Sort(Sort.Direction.DESC,"keterangan"));
        PageRequest pageRequest = new PageRequest(page -1,size, sort);
        return service.getAll(pageRequest) ;
    }

    @RequestMapping(value = "{id}",
                    method = RequestMethod.GET)
    public CategoryBarang getById(@PathVariable Long id) {
        CategoryBarang categoryBarang= service.getById(id);
        if (categoryBarang==null){
            return new CategoryBarang();
        }else{
            return categoryBarang;
        }
    }


    @RequestMapping(method = RequestMethod.POST,
                    consumes = "application/json")
    public CategoryBarang save(@RequestBody CategoryBarang categoryBarang){
        logger.info("save " + categoryBarang);
        return service.save(categoryBarang);
    }


}
