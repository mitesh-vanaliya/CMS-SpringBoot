package com.example.CustomerMangSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CustomerMangSys.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

	@Query(value = "select * from customer c where c.name like ?1%",
			nativeQuery = true)
	List<CustomerEntity> findByName(String name);

}
