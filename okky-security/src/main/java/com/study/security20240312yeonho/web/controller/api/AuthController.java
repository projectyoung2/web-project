package com.study.security20240312yeonho.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.security20240312yeonho.handler.aop.annotation.Log;
import com.study.security20240312yeonho.handler.aop.annotation.Timer;
import com.study.security20240312yeonho.handler.aop.annotation.ValidCheck;
import com.study.security20240312yeonho.handler.exception.CustomValidationApiException;
import com.study.security20240312yeonho.service.auth.AuthService;
import com.study.security20240312yeonho.service.auth.PrincipalDetailsService;
import com.study.security20240312yeonho.web.dto.CMRespDto;
import com.study.security20240312yeonho.web.dto.SignupReqDto;
import com.study.security20240312yeonho.web.dto.UsernameCheckReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final PrincipalDetailsService principalDetailsService;
	private final AuthService authService;
	
	@ValidCheck
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
		
//		if(bindingResult.hasErrors()) {
//			Map<String, String> errorMessage = new HashMap<String, String>();
//			bindingResult.getFieldErrors().forEach(error -> {
//				System.out.println("오류발생 필드명: " + error.getField());
//				System.out.println("오류발생 상태메세지: " + error.getDefaultMessage());
//				errorMessage.put(error.getField(), error.getDefaultMessage());
//				});
//			//return ResponseEntity.ok().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMessage));
//			throw new CustomValidationApiException("유효성 검사 실패", errorMessage);
//		}
		
		boolean status = false;
		try {
			status = principalDetailsService.addUser(signupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패", status));
		}		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공", status));
	}
	@Log
	@Timer
	@ValidCheck
	@GetMapping("/signup/validation/username")
	public ResponseEntity<?> checkUsername(@Valid @RequestBody UsernameCheckReqDto usernameCheckReqDto, BindingResult bindingResult) {
		Map<String, String> errorMessage = new HashMap<String, String>();
		
//		if(bindingResult.hasErrors()) {
//			bindingResult.getFieldErrors().forEach(error -> {
//				System.out.println("오류발생 필드명: " + error.getField());
//				System.out.println("오류발생 상태메세지: " + error.getDefaultMessage());
//				errorMessage.put(error.getField(), error.getDefaultMessage());
//				});
//			//return ResponseEntity.ok().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMessage));
//			throw new CustomValidationApiException("유효성 검사 실패", errorMessage);
//		}
		//return ResponseEntity.ok().body(new CMRespDto<>(1, "유효성 검사 성공", true));
		boolean status =false;
		
		try {
			status = authService.checkUsername(usernameCheckReqDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "서버 오류", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원 가입 여부", status));
	}
} 






















