package com.sava.controller;

import com.sava.model.Event;
import com.sava.model.Store;
import com.sava.repository.interfaces.StoreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class StoreController {

    private StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    public Store create(@RequestBody Store store) {
        return storeRepository.saveAndFlush(store);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public Store get(@PathVariable Long id) {
        return storeRepository.findOne(id);
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<Store> list() {
        return storeRepository.findAll();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    public Store update(@PathVariable Long id, @RequestBody Event event) {
        Store loadedStore = storeRepository.findOne(id);
        BeanUtils.copyProperties(event, loadedStore);
        return storeRepository.saveAndFlush(loadedStore);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Store loadedStore = storeRepository.findOne(id);
        storeRepository.delete(loadedStore);
    }
}
