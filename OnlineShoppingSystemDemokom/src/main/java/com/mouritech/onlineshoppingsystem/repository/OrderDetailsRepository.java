package com.mouritech.onlineshoppingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlineshoppingsystem.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

	List<OrderDetails> findByOrder_OrderId(String orderId);


//	List<OrderDetails> findByOrder_Customer_CustId(String custId);




	
}
