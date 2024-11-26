package com.example.demo.dto;

import java.util.stream.Collectors;

import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;

public class AccountDto {
	
	private long id;
	private String username;
	private boolean active;
	private EmployeeDto employee;
	
	public AccountDto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public EmployeeDto getEmployeedto() {
		return employee;
	}

	public void setEmployeedto(EmployeeDto employeedto) {
		this.employee = employeedto;
	}

	public static AccountDto toDto(Account account) {
		if(account==null) {
			return null;
		}
		
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setUsername(account.getUserName());
		accountDto.setActive(account.isActive());
		if(account.getEmployee()!=null) {
			accountDto.setEmployeedto(EmployeeDto.toDto(account.getEmployee()));
		}
		return accountDto;
	}
	
	public static Account toEntity(AccountDto accountDto) {
		if(accountDto==null) {
			return null;
		}
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setUserName(accountDto.getUsername());
		account.setActive(accountDto.isActive());
		if(accountDto.getEmployeedto()!=null) 
			account.setEmployee(EmployeeDto.toEntity(accountDto.getEmployeedto()));
		
		return account;
	}
	
	
	
	

}
