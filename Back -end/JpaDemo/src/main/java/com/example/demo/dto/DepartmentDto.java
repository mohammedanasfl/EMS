package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;

public class DepartmentDto {
	
	private long id;
	private String name;
	private List<EmployeeDto>employee;
	
	public DepartmentDto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeDto> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeDto> employee) {
		this.employee = employee;
	}
	public static DepartmentDto toDto(Department department) {
		if(department==null) {
			return null;
		}
		
		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());
		if(department.getEmployee()!=null) {
			departmentDto.setEmployee(department.getEmployee()
		.stream().map(EmployeeDto::toDto).collect(Collectors.toList()));
		}
		return departmentDto;
	}
	public static Department toEntity(DepartmentDto departmentDto) {
		if(departmentDto==null) {
			return null;
		}
		Department department=new Department();
		department.setId(departmentDto.getId());
		department.setName(departmentDto.getName());
		if(departmentDto.getEmployee()!=null) 
		department.setEmployee(departmentDto.getEmployee().stream().map(EmployeeDto::toEntity).collect(Collectors.toList()));
		
		return department;
	}
	

}
