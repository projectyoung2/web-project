package com.study.security20240312yeonho.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UsernameCheckReqDto {
	
	@NotBlank(message = "빈값일 수 없습니다.")
	@Size(max = 16, min = 4)
	private String username;
}
