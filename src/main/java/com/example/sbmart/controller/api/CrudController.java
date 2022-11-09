package com.example.sbmart.controller.api;

import com.example.sbmart.ifs.CrudInterface;

import com.example.sbmart.model.network.Header;
import com.example.sbmart.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    @Autowired(required = true)
    protected BaseService<Req, Res, Entity> baseService;
    @Override
    @PostMapping()
    public Header<Res> create(Header<Req> request) {
        return null;
    }

    @Override
    @GetMapping("{t}")
    public <T> Header<Res> read(T t) {
        return null;
    }

    @Override
    @PutMapping()
    public Header<Res> update(Header<Req> request) {
        return null;
    }

    @Override
    @DeleteMapping("{t}")
    public <T> Header<Res> delete(T t) {
        return null;
    }
}