package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountJpa;
import com.example.demo.dao.DepartmentJpa;
import com.example.demo.dao.EmployeeJpa;
import com.example.demo.dao.SkillJpa;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.SkillDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;
import com.example.demo.exception.DepartmentNotFoundException;

import jakarta.transaction.Transactional;
@Service
@Primary
public  class JpaService implements AppService{
	@Autowired
	private EmployeeJpa employeeJpa;
	@Autowired
	private AccountJpa accountJpa;
	@Autowired
	private SkillJpa skillJpa;
	@Autowired
	private DepartmentJpa departmentJpa;
	@Override
	public DepartmentDto saveDepartment(DepartmentDto department) {
		
	 Optional<Department>dept=departmentJpa.findByDepartment(department.getName());
		if(!dept.isPresent()) {
		Department d=departmentJpa.save(DepartmentDto.toEntity(department));
		return DepartmentDto.toDto(d);
		}
		return department;
		
	}
	@Override
	public DepartmentDto findDepartmentById(long departmentId) {
		return departmentJpa.findById(departmentId).map(DepartmentDto::toDto).orElse(null);
	}
	@Override
	public DepartmentDto updateDepartmentId(long departmentId, DepartmentDto departmentDto) {
		if(findDepartmentById(departmentId)==null) {
			throw new DepartmentNotFoundException("Department ethier does not exits or value ");
		}
	Department d=departmentJpa.save(DepartmentDto.toEntity(departmentDto));
	if(d==null) {
		throw new DepartmentNotFoundException("Department ethier does not exits or value ");
	}
		return DepartmentDto.toDto(d);
		
	}
	@Override
	public List<EmployeeDto> getAllEmployess() {
		return (employeeJpa.findAll().stream().map(EmployeeDto::toDto).collect(Collectors.toList()));
	}
	@Override
	public EmployeeDto updateAccount(long employeeId, AccountDto accountDto) {
		Employee employee=employeeJpa.findById(employeeId).orElse(null);
		
		if(employee==null) {
			throw new DepartmentNotFoundException("Department/Employee ethier does not exits or value ");
		}
		
		employee.getAccount().setActive(accountDto.isActive());
		
		return EmployeeDto.toDto(employeeJpa.save(employee));
	}
	@Override
	public List<DepartmentDto> getAllDepartments() {
		return departmentJpa.findAll().stream().map(DepartmentDto::toDto).collect(Collectors.toList());
	}
	@Override
	public List<SkillDto> getAllSkill() {
		return skillJpa.findAll().stream().map(SkillDto::toDto).collect(Collectors.toList());
	}
	@Override
	@Transactional
	public DepartmentDto saveEmployee(long id, EmployeeDto employeeDto) {
	    Optional<Department> optionalDepartment = departmentJpa.findById(id);
	    
	    if (optionalDepartment.isPresent()) {
	        Department department = optionalDepartment.get();
	        
	        Employee newEmployee = EmployeeDto.toEntity(employeeDto);
	        newEmployee.setDepartment(department);
	        List<Skill>get=getExistingSkills(employeeDto.getSkill());
	        newEmployee.setSkills(get);
	        newEmployee = employeeJpa.save(newEmployee);
	       
	        department.getEmployee().add(newEmployee);
	        
	        department = departmentJpa.save(department);
	      
	        return DepartmentDto.toDto(department);
	    }
	    
	    return null;  
	}
	private List<Skill> getExistingSkills(List<SkillDto> skill) {
		List<Skill> existingSkills = new ArrayList<>();
	    
	    for (SkillDto skillDto : skill) {
	        Skill skillEntity = skillJpa.findBySkill(skillDto.getName()).orElse(null);
	        if (skillEntity != null) {
	            existingSkills.add(skillEntity);
	        }
	    }
		return existingSkills;
	}
	@Override
	public void saveSkill(SkillDto skilldto) {
		Optional<Skill>s=skillJpa.findBySkill(skilldto.getName());
		if(!s.isPresent()) {
			skillJpa.save(SkillDto.toEntity(skilldto));
		}
		
	}

		
		
	
	
	

	
	
	

}
