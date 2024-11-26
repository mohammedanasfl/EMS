package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * CREATE TABLE account (
  id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
  username VARCHAR(50) NOT NULL,
  active BOOLEAN NOT NULL,
  employee_id BIGINT NOT NULL,
  CONSTRAINT fk_account_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);

 */
@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="active")
	private boolean active;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Account() {
		
	}

	public Account(long id, String username, boolean active, Employee employee) {
		super();
		this.id = id;
		this.username = username;
		this.active = active;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}