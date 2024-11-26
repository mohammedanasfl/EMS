package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Department;


public interface DepartmentJpa extends JpaRepository<Department, Long>{
	
	@Query("select d from Department d where name=:name")
	public Optional<Department> findByDepartment(@Param("name")String department);
}
