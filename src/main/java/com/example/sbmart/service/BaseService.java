package com.example.sbmart.service;

import com.example.sbmart.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {
    @Autowired(required = false)
    protected JpaRepository<Entity, Integer> baseRepository;
//    @Autowired(required = false)
//    protected JpaRepository<Entity, String> baseRepositoryS;

}