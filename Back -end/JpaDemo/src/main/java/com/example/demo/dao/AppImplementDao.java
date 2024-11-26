package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppImplementDao implements AppDao{
	@Autowired
	private EntityManager entiy;
	
	
	public AppImplementDao(EntityManager entiy) {
		this.entiy=entiy;
	}

	@Override
	@Transactional
	public Optional<Department> saveDepartment(Department department) {
		return Optional.ofNullable(entiy.merge(department));
	}

	@Override
	public Optional<Employee> findEmployeById(long employeeId) {
		return Optional.ofNullable(entiy.find(Employee.class,employeeId));
	}

	@Override
	public Optional<Account> findAccountsById(long accountId) {
		return Optional.ofNullable(entiy.find(Account.class,accountId));
	}

	@Override
	public Optional<Department> findDepartmentById(long departmentId) {
		return Optional.ofNullable(entiy.find(Department.class,departmentId));
	}

	@Override
	public Optional<Skill> findSkillById(long skillId) {
		return Optional.ofNullable(entiy.find(Skill.class,skillId));
	}

	@Override
	public List<Employee> findByFirstName(String name) {
		TypedQuery<Employee>query=entiy.createQuery("select e from Employee e where firstName=:value",Employee.class);
		query.setParameter("value",name);
		return query.getResultList();
	}

	@Override
	public void deleteById(long id) {
		TypedQuery<Employee>query=entiy.createQuery("select e from Employee e where e.department.id=:id",Employee.class);
		query.setParameter("id",id);
		List<Employee>delete=query.getResultList();
		delete.stream().forEach(entiy::remove);
		
		Department dept = entiy.find(Department.class,id);
        entiy.remove(dept);
		
	}
}
