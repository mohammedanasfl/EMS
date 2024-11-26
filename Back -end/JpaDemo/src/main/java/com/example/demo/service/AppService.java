package com.example.demo.service;




import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.SkillDto;
import com.example.demo.entity.Department;

public interface AppService {
	
	public DepartmentDto saveDepartment(DepartmentDto department);
	public DepartmentDto findDepartmentById(long departmentId);
	public DepartmentDto updateDepartmentId(long departmentId, DepartmentDto departmentDto);
	public List<EmployeeDto>getAllEmployess();
	public EmployeeDto updateAccount(long employeeId, AccountDto accountDto);
	public List<DepartmentDto> getAllDepartments();
	public List<SkillDto> getAllSkill();
	public DepartmentDto saveEmployee(long id,EmployeeDto employeeDto);
	public void saveSkill(SkillDto skildto);
	
	

}
