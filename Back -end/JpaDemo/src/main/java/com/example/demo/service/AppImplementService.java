package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppImplementDao;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.SkillDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;

import jakarta.persistence.TypedQuery;

@Service
public class AppImplementService  {
	@Autowired
	private AppImplementDao dao;
	
	public AppImplementService(AppImplementDao dao) {
		this.dao=dao;
	}
//
//	@Override
//	public DepartmentDto saveDepartment(Department department) {
//		Department d=dao.saveDepartment(department).orElse(null);
//		return DepartmentDto.toDto(d);
//	}



	public DepartmentDto findDepartmentById(long departmentId) {
		return dao.findDepartmentById(departmentId).map(DepartmentDto::toDto).orElse(null);
	}

	



	


	


}
