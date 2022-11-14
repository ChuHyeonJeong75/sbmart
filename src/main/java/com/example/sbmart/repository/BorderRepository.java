package com.example.sbmart.repository;

import com.example.sbmart.model.entity.Border;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorderRepository extends JpaRepository<Border, Integer> {
//    @Query("select b from Border b join fetch b.Customer")
//    List<Border> findAllFetchJoin();
}
