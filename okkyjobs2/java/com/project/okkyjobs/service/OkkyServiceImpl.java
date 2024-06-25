package com.project.okkyjobs.service;

import org.springframework.stereotype.Service;


import com.project.okkyjobs.domain.OkkyPractice;
import com.project.okkyjobs.domain.OkkyRepositiory;
import com.project.okkyjobs.web.dto.OkkyReqDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OkkyServiceImpl implements OkkyService{

	private final OkkyRepositiory okkyRepositiory;
	
	@Override
	public boolean projectintroduce(OkkyReqDto okkyReqDto) throws Exception {
		OkkyPractice okkyPractice = okkyReqDto.toEntity();
		int project = okkyRepositiory.projectinput(okkyPractice);
		System.out.println(project);
		return false;
		
	}

}
