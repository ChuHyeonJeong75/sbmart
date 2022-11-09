package com.example.sbmart.repository;

import com.example.sbmart.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// 다른 레파지토리는 baseService (baseRepository)
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{ }
