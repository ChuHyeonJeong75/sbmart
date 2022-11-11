package com.example.sbmart.repository;

import com.example.sbmart.model.entity.OrderTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTblRepository extends JpaRepository<OrderTbl, Integer>{
}
