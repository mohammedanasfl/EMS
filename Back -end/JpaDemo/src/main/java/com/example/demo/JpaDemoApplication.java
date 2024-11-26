package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;
import com.example.demo.service.AppService;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(AppService service) {
//		return runner ->{
//			Department department =new Department();
//			department.setName("IT");
//			
//			List<Employee>allEmployees=getEmployee();
//			allEmployees.stream().forEach(e-> e.setDepartment(department));
//			department.setEmployee(allEmployees);
//			System.out.print(service.saveDepartment(DepartmentDto.toDto(department)));
//			
//			
//			
//		};
//	}
//	
//	public Skill setSkills(String name) {
//		Skill skill=new Skill();
//		skill.setSkill(name);
//		return skill;
//	} 
//	public List<Skill> getSkillsListJava(){
//		return List.of(setSkills("sowrdsMan"),setSkills("ThirdSowrdStyle"));
//	}
//	public List<Skill> getSkillsListManager(){
//		return List.of(setSkills("Navigator"),setSkills("CatBulger"));
//	}
//	public List<Employee> getEmployee() {
//		
//		Employee employee=new Employee();
//		employee.setFirstName("Zoro");
//		employee.setLastName("roranao");
//		employee.setEmail("zoro@gamil.com");
//		Account account=new Account();
//		account.setUserName("zoro@gamil.com");
//		account.setActive(true);
//		account.setEmployee(employee);
//		employee.setAccount(account);
//		employee.setSkills(getSkillsListJava());
//		
//		Employee employee2=new Employee();
//		employee2.setFirstName("nami");
//		employee2.setLastName("Monkey D");
//		employee2.setEmail("nami@gamil.com");
//		Account account2=new Account();
//		account2.setUserName("nami@gamil.com");
//		account2.setActive(false);
//		account2.setEmployee(employee2);
//		employee2.setAccount(account2);
//		
//		employee2.setSkills(getSkillsListManager());
//		
//		return List.of(employee,employee2);
//		
//		
//		
//	}

}
