package com.mouritech.onlineshoppingsystem.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mouritech.onlineshoppingsystem.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



	Optional<Order> findByOrderId(String orderId);

	List<Order> findByCustomer(String custId);
	
}
