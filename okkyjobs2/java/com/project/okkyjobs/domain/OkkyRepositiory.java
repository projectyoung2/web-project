package com.project.okkyjobs.domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OkkyRepositiory {

	public int projectinput(OkkyPractice okkyPractice) throws Exception; 
}
