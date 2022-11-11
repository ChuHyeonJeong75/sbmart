package com.example.sbmart.controller.api;

import com.example.sbmart.ifs.CrudInterface;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    @Autowired(required = false)
    protected BaseService<Req, Res, Entity> baseService;

    @Override
    @PostMapping()
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{t}")
    public <T> Header<Res> read(@PathVariable T t) { return baseService.read(t); }

    @Override
    @PutMapping()
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{t}")
    public <T> Header<Res> delete(@PathVariable T t) {
        return baseService.delete(t);
    }
}