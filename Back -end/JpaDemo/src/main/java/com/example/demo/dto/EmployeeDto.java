package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;



public class EmployeeDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	private AccountDto account;
	private DepartmentDto department;
	private List<SkillDto>skill;
	
	public EmployeeDto() {
		
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public AccountDto getAccountDto() {
		return account;
	}


	public void setAccountDto(AccountDto accountDto) {
		this.account = accountDto;
	}


	public DepartmentDto getDepartmentDto() {
		return department;
	}


	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.department = departmentDto;
	}


	public List<SkillDto> getSkill() {
		return skill;
	}


	public void setSkill(List<SkillDto> skill) {
		this.skill= skill;
	}


	public static EmployeeDto toDto(Employee employee) {
		
		if(employee==null) {
			return null;
		}
		
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		
		if(employee.getAccount()!=null) {
			AccountDto accountDto=new AccountDto();
			accountDto.setId(employee.getAccount().getId());
			accountDto.setUsername(employee.getAccount().getUserName());
			accountDto.setActive(employee.getAccount().isActive());
			employeeDto.setAccountDto(accountDto);
			
		}
		if(employee.getDepartment()!=null) {
			DepartmentDto departmentDto=new DepartmentDto();
			departmentDto.setId(employee.getDepartment().getId());
			departmentDto.setName(employee.getDepartment().getName());
			employeeDto.setDepartmentDto(departmentDto);
		}
		if(employee.getSkills()!=null) {
			employeeDto.setSkill(employee.getSkills().stream().map(e->{
				SkillDto skillDto=new SkillDto();
				skillDto.setId(e.getId());
				skillDto.setName(e.getSkill());
				return skillDto;
				
			}).collect(Collectors.toList()));
		}
		return employeeDto;
		
	}
	public static Employee toEntity(EmployeeDto employeeDto) {
		if(employeeDto==null)
		return null;
		
		Employee employee=new Employee();
		
		employee.setId(	employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		
		if(employeeDto.getAccountDto()!=null) {
			Account account=new Account();
			account.setId(employeeDto.getAccountDto().getId());
			account.setUserName(employeeDto.getAccountDto().getUsername());
			account.setActive(employeeDto.getAccountDto().isActive());
			account.setEmployee(employee);
			employee.setAccount(account);
			
		}
		if(employeeDto.getDepartmentDto()!=null) {
			Department department=new Department();
			department.setId(employeeDto.getDepartmentDto().getId());
			department.setName(employeeDto.getDepartmentDto().getName());
		
			employee.setDepartment(department);
		}
		if(employeeDto.getSkill()!=null) {
			employee.setSkills(employeeDto.getSkill().stream().map(
					e->{
						Skill skill=new Skill();
						skill.setId(e.getId());
						skill.setSkill(e.getName());
						
						return skill;
					}).collect(Collectors.toList()));
		}
		
		
		
		return employee;
	}
	

}
