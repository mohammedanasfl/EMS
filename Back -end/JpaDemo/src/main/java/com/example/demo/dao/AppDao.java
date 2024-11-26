package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;

public interface AppDao {
	
	public Optional<Department> saveDepartment(Department department);
	public Optional<Employee> findEmployeById(long employeeId);
	public Optional<Account> findAccountsById(long accountId);
	public Optional<Department>findDepartmentById(long departmentId);
	public Optional<Skill>findSkillById(long skillId);
	public List<Employee>findByFirstName(String name);
	public void deleteById(long id);

}
