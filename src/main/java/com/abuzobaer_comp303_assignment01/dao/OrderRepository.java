package com.abuzobaer_comp303_assignment01.dao;

import com.abuzobaer_comp303_assignment01.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
