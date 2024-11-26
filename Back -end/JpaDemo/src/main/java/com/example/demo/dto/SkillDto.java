package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Skill;



public class SkillDto {
	
	private long id;
	private String name;
	private List<EmployeeDto>employee;
	
	public SkillDto() {
		
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

	public void setEmployee(List<EmployeeDto> employeeDto) {
		this.employee = employeeDto;
	}
	
	public static SkillDto toDto(Skill skill) {
		if(skill==null) {
			return null;
		}
		
		SkillDto skillDto=new SkillDto();
		skillDto.setId(skill.getId());
		skillDto.setName(skill.getSkill());
		return skillDto;
	}
	
	public static Skill toEntity(SkillDto skillDto) {
		if(skillDto==null) {
			return null;
		}
		Skill skill=new Skill();
		skill.setId(skillDto.getId());
		skill.setSkill(skillDto.getName());
		if(skillDto.getEmployee()!=null)
		skill.setEmployee(skillDto.getEmployee().stream().map(EmployeeDto::toEntity).collect(Collectors.toList()));
		return skill;
	}
	
	

}
