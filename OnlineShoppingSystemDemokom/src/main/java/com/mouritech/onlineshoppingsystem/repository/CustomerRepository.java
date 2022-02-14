package com.mouritech.onlineshoppingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlineshoppingsystem.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByCustId(String CustId);
	List<Customer> findByCustName(String CustId);
}
