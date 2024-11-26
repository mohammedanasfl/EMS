package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Skill;

public interface SkillJpa extends JpaRepository<Skill, Long>{
	@Query("select s from Skill s where skill=:skill")
	public Optional<Skill> findBySkill(@Param("skill")String skill);

}
