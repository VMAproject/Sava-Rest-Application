package com.sava.controller;

import com.sava.model.Event;
import com.sava.model.Store;
import com.sava.repository.interfaces.StoreRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(name = "Store API", description = "Provides a list of methods that manage Stores")
public class StoreController {

    private StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    @ApiMethod(description = "Create one Store and save it to the database")
    public Store create(@RequestBody Store store) {
        return storeRepository.saveAndFlush(store);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    @ApiMethod(description = "Get one Store from the database by id")
    public Store get(@ApiPathParam(name = "id") @PathVariable Long id) {
        return storeRepository.findOne(id);
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    @ApiMethod(description = "Get all Stores from the database")
    public List<Store> list() {
        return storeRepository.findAll();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    @ApiMethod(description = "Edit Store's fields by id and save it to the database")
    public Store update(@ApiPathParam(name = "id") @PathVariable Long id, @RequestBody Event event) {
        Store loadedStore = storeRepository.findOne(id);
        BeanUtils.copyProperties(event, loadedStore);
        return storeRepository.saveAndFlush(loadedStore);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Delete one Store from the database by id")
    public void delete(@ApiPathParam(name = "id") @PathVariable Long id) {
        Store loadedStore = storeRepository.findOne(id);
        storeRepository.delete(loadedStore);
    }
}
