package com.project.okkyjobs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.okkyjobs.service.OkkyService;
import com.project.okkyjobs.web.dto.CMRespDto;
import com.project.okkyjobs.web.dto.OkkyReqDto;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/okky/auth")
@RequiredArgsConstructor
public class OkkyMAinController {

	private final OkkyService okkyService;
	
	@PostMapping("/project")
	public ResponseEntity<?> ProjectRead(@RequestBody @ModelAttribute OkkyReqDto okkyReqDto) {
		System.out.println(okkyReqDto);
		boolean result = false;
		
		try {
		 okkyService.projectintroduce(okkyReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패", false));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "성공", true));
	}
}
