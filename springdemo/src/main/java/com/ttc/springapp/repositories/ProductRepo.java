package com.ttc.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttc.springapp.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
