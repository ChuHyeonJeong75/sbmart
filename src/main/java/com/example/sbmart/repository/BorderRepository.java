package com.example.sbmart.repository;

import com.example.sbmart.model.entity.Border;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorderRepository extends JpaRepository<Border, Integer> {
}
