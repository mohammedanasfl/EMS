package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.SkillDto;

import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.service.JpaService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	private JpaService service;
	
	
	@GetMapping("/department/{id}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable(name="id") long departmentId){
		DepartmentDto dept =service.findDepartmentById(departmentId);
		if(dept==null) {
			throw new DepartmentNotFoundException("Department or DepartmentId doesNot Exits");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dept);
		
	}
	@PatchMapping("/department/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable(name="id") long departmentId,
			@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto dept=service.updateDepartmentId(departmentId,departmentDto);
		if(dept==null) {
			throw new DepartmentNotFoundException("Department or DepartmentId doesNot Exits");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dept);
		
	}
	@GetMapping("/allEmployess")
	public List<EmployeeDto> getAllEmployess(){
		return service.getAllEmployess();
	}
	@PatchMapping("/employee/{id}/status")
	public ResponseEntity<EmployeeDto>updateAccount(@PathVariable(name="id") long employeeId,@RequestBody AccountDto accountDto){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.updateAccount(employeeId,accountDto));
	}
	@GetMapping("/all/department")
	public List<DepartmentDto> getAlldepartment(){
		return service.getAllDepartments();
	}
	@GetMapping("/all/skills")
	public List<SkillDto> getAllSkills(){
		return service.getAllSkill();
	}
	@PostMapping("/all/department")
	public void addEmployess(@RequestBody DepartmentDto department) {
		 service.saveDepartment(department);
	}
	@PatchMapping("/add/employee/{id}")
	public void addEmployee(@PathVariable(name="id")long id,@RequestBody EmployeeDto employeeDto) {
		service.saveEmployee(id, employeeDto);
	}
	@PostMapping("/all/skill")
	public void saveSkill(@RequestBody SkillDto skillDto) {
		service.saveSkill(skillDto);
	}
	
}
